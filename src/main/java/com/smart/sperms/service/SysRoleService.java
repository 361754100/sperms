package com.smart.sperms.service;

import com.smart.sperms.dao.SysRoleDao;
import com.smart.sperms.dao.SysRoleMenuDao;
import com.smart.sperms.dao.model.SysRole;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.SysRoleEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(SysRoleEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        int roleId = req.getRoleId();
        boolean isExist = this.isExists(roleId);
        if(isExist) {
            wrapper.setResultMsg("该菜单信息已存在");
            return wrapper;
        }
        SysRole info = new SysRole();
        info.setRoleName(req.getRoleName());
        info.setRoleRemark(req.getRoleRemark());
        info.setRoleStatus(req.getRoleStatus());
        info.setCreationTime(new Date());

        int cnt = sysRoleDao.saveData(info);
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
    public CommonWrapper updateInfo(SysRoleEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        SysRole info = new SysRole();
        info.setRoleName(req.getRoleName());
        info.setRoleRemark(req.getRoleRemark());
        info.setRoleStatus(req.getRoleStatus());
        info.setCreationTime(new Date());
        info.setModifyTime(new Date());

        int cnt = sysRoleDao.updateData(req.getRoleId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param roleIds
     * @return
     */
    public CommonWrapper deleteInfo(List<Integer> roleIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = sysRoleDao.delData(roleIds);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 删除关联关系
     * @param roleId
     * @param menuId
     * @return
     */
    public CommonWrapper delRelationByRoleMenuId(int roleId, int menuId) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = sysRoleMenuDao.delRelationByRoleMenuId(roleId, menuId);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 删除关联关系
     * @param roleIds
     * @return
     */
    public CommonWrapper delRelationByRoleIds(List<Integer> roleIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = sysRoleMenuDao.delRelationByRoleIds(roleIds);

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

        int total = sysRoleDao.queryPageTotal(beginTime, endTime, keywords);
        List<SysRole> result = sysRoleDao.queryPage(pageNo, pageSize, beginTime, endTime, keywords);

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
    public SingleQueryWrapper findRecordById(int recordId) {
        SingleQueryWrapper wrapper = new SingleQueryWrapper();

        SysRole condition = new SysRole();
        condition.setRoleId(recordId);

        List<SysRole> result = sysRoleDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param roleId
     * @return
     */
    private boolean isExists(int roleId) {
        boolean isExist= false;
        SysRole condition = new SysRole();
        condition.setRoleId(roleId);

        List<SysRole> dataList = sysRoleDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
