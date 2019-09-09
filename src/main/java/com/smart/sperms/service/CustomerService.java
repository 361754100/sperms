package com.smart.sperms.service;

import com.smart.sperms.dao.CustomerDao;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.UserCustomerDao;
import com.smart.sperms.dao.dto.SysMenuDto;
import com.smart.sperms.dao.model.*;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.CustomerAddUserRelationReq;
import com.smart.sperms.request.CustomerEditReq;
import com.smart.sperms.request.EquipmentEditReq;
import com.smart.sperms.request.SysRoleAddMenuRelationReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.ListQueryWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private UserCustomerDao userCustomerDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(CustomerEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String customerNo = req.getCustomerNo();
        boolean isExist = this.isExists(customerNo);
        if(isExist) {
            wrapper.setResultMsg("该客户信息已存在");
            return wrapper;
        }

        Customer info = new Customer();
        info.setCustomerNo(req.getCustomerNo());
        info.setCustomerSex(req.getCustomerSex());
        info.setCustomerPhone(req.getCustomerPhone());
        info.setCustomerName(req.getCustomerName());
        info.setCustomerEmail(req.getCustomerEmail());
        info.setCustomerCompany(req.getCustomerCompany());
        info.setCustomerAge(req.getCustomerAge());
        info.setCustomerAddr(req.getCustomerAddr());
        info.setCustomerQq(req.getCustomerQq());
        info.setCustomerWx(req.getCustomerWx());
        info.setCreationTime(new Date());

        int cnt = customerDao.saveData(info);
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
    public CommonWrapper updateInfo(CustomerEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        Customer info = new Customer();
        info.setCustomerAddr(req.getCustomerAddr());
        info.setCustomerAge(req.getCustomerAge());
        info.setCustomerCompany(req.getCustomerCompany());
        info.setCustomerEmail(req.getCustomerEmail());
        info.setCustomerName(req.getCustomerName());
        info.setCustomerPhone(req.getCustomerPhone());
        info.setCustomerSex(req.getCustomerSex());
        info.setCustomerQq(req.getCustomerQq());
        info.setCustomerWx(req.getCustomerWx());
        info.setModifyTime(new Date());

        int cnt = customerDao.updateData(req.getCustomerNo(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param customerNos
     * @return
     */
    public CommonWrapper deleteInfo(List<String> customerNos) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = customerDao.delData(customerNos);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

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

        int total = customerDao.queryPageTotal(beginTime, endTime, keywords);
        List<Customer> result = customerDao.queryPage(pageNo, pageSize, beginTime, endTime, keywords);

        wrapper.setTotalCount(total);
        wrapper.setPageNo(pageNo);
        wrapper.setRecords(result);
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 查询单个结果
     * @param recordId
     * @return
     */
    public SingleQueryWrapper findRecordById(String recordId) {
        SingleQueryWrapper wrapper = new SingleQueryWrapper();

        Customer condition = new Customer();
        condition.setCustomerNo(recordId);

        List<Customer> result = customerDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param customerNo
     * @return
     */
    private boolean isExists(String customerNo) {
        boolean isExist= false;
        Customer condition = new Customer();
        condition.setCustomerNo(customerNo);

        List<Customer> dataList = customerDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }


    /**
     * 删除客户与系统用户的关联关系
     * @param customerNo
     * @param userId
     * @return
     */
    public CommonWrapper delRelationByCustomerUserId(String customerNo, String userId) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = userCustomerDao.delRelationByCustomerUserId(customerNo, userId);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 删除关联关系
     * @param customerNos
     * @return
     */
    public CommonWrapper delRelationByCustomerNos(List<String> customerNos) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = userCustomerDao.delRelationByCustomerNos(customerNos);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 根据客户编号获取系统用户列表
     * @param customerNo
     * @return
     */
    public ListQueryWrapper findUsersByCustomerNo(String customerNo) {
        ListQueryWrapper wrapper = new ListQueryWrapper();
        List<Users> list = userCustomerDao.queryUsersByCustomerNo(customerNo);
        if(!CollectionUtils.isEmpty(list)) {
            for(Users user:list) {
                user.setuPassword("");
            }
        }
        wrapper.setRecords(list);
        return wrapper;
    }

    /**
     * 客户关联系统用户
     * @param req
     * @return
     */
    public CommonWrapper addCustomerUserRelation(CustomerAddUserRelationReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultMsg("客户关联系统用户异常");
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        if(CollectionUtils.isEmpty(req.getUserIds())) {
            wrapper.setResultMsg("系统用户ID不能为空");
            return wrapper;
        }

        int cnt = 0;
        for(String uId: req.getUserIds()) {
            if(!userCustomerDao.isRelationExists(req.getCustomerNo(), uId)) {
                UsersCustomerRelation relation = new UsersCustomerRelation();
                relation.setCustomerNo(req.getCustomerNo());
                relation.setuId(uId);

                cnt +=userCustomerDao.saveData(relation);
            }
        }
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        } else {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg("关联关系已存在");
        }

        return wrapper;
    }
}
