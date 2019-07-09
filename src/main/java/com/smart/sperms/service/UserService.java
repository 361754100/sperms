package com.smart.sperms.service;

import com.smart.sperms.dao.UsersDao;
import com.smart.sperms.dao.model.Users;
import com.smart.sperms.dao.model.UsersExample;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.UsersEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.utils.EncryptUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import static com.smart.sperms.utils.EncryptUtils.encryptPasswordByPassword;

/**
 * @Descript 用户管理业务实现类
 * @Author fuyuanming
 * @Date 2019-02-20 15:05:10
 * @Version 1.0
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsersDao usersDao;

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @param keywords  关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String beginTime, String endTime, String keywords) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = usersDao.queryPageTotal(beginTime, endTime, keywords);
        List<Users> result = usersDao.queryPage(pageNo, pageSize, beginTime, endTime, keywords);

        wrapper.setTotalCount(total);
        wrapper.setPageNo(pageNo);
        wrapper.setRecords(result);
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 根据ID查询用户详细信息
     * @param id 用户ID
     * @return 用户详细信息
     */
    /**
     * 查询单个结果
     * @param recordId
     * @return
     */
    public SingleQueryWrapper findRecordById(String recordId) {
        SingleQueryWrapper wrapper = new SingleQueryWrapper();

        Users condition = new Users();
        condition.setuId(recordId);

        List<Users> result = usersDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param uId
     * @return
     */
    private boolean isExists(String uId) {
        boolean isExist= false;
        Users condition = new Users();
        condition.setuId(uId);

        List<Users> dataList = usersDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(UsersEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String uId = req.getuId();
        boolean isExist = this.isExists(uId);
        if(isExist) {
            wrapper.setResultMsg("该用户账号已存在");
            return wrapper;
        }
        Users info = new Users();
        info.setuId(req.getuId());
        info.setuName(req.getuName());

        String encryptPwd = EncryptUtils.encryptPasswordByPassword(req.getuPassword());
        info.setuPassword(encryptPwd);

        info.setRoleId(req.getRoleId());
        info.setCreationTime(new Date());

        int cnt = usersDao.saveData(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 修改记录
     * @param req
     * @return
     */
    public CommonWrapper updateInfo(UsersEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        Users info = new Users();
        info.setuName(req.getuName());
//        info.setuPassword(req.getuPassword());
        info.setRoleId(req.getRoleId());
        info.setModifyTime(new Date());

        int cnt = usersDao.updateData(req.getuId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 修改密码
     * @param uId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public CommonWrapper changePassword(String uId, String oldPassword, String newPassword) {
        CommonWrapper wrapper = new CommonWrapper();
        Users condition = new Users();
        condition.setuId(uId);

        Users users = usersDao.querySingle(condition);
        if (users == null) {
            wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
            wrapper.setResultMsg("用户信息不存在！");
            return wrapper;
        }
        String encryptOldPassword = EncryptUtils.encryptPasswordByPassword(oldPassword);
        String encryptNewPassword = EncryptUtils.encryptPasswordByPassword(newPassword);
        if (!encryptOldPassword.equals(users.getuPassword())) {
            wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
            wrapper.setResultMsg("原密码错误！");
            return wrapper;
        }
        if (StringUtils.isNotEmpty(newPassword)) {
            Users tmp = new Users();
            tmp.setuPassword(encryptNewPassword);
            tmp.setModifyTime(new Date());
            usersDao.updateData(users.getuId(), tmp);

            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg("密码修改成功！");
        } else {
            wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
            wrapper.setResultMsg("新密码不能为空！");
        }

        return wrapper;
    }

    /**
     * 批量重置密码
     * @param ids ID集合
     * @return
     */
    @Transactional
    public CommonWrapper resetPassword(List<String> ids) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultMsg("重置密码成功");

        UsersExample example = new UsersExample();
        example.createCriteria().andUIdIn(ids);

        try {
            List<Users> list = usersDao.queryListByExample(example);
            String resetPassword = EncryptUtils.encryptPasswordByPassword("123456");

            Date modifyDate = new Date();
            list.stream().forEach(users -> {
                Users tmp = new Users();
                tmp.setuPassword(resetPassword);
                tmp.setModifyTime(modifyDate);

                usersDao.updateData(users.getuId(), tmp);
            });
        } catch (Exception e) {
            wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
            wrapper.setResultMsg("重置密码失败");
            throw e;
        }

        return wrapper;
    }

    /**
     * 删除记录
     * @param uIds
     * @return
     */
    public CommonWrapper deleteInfo(List<String> uIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = usersDao.delData(uIds);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

}
