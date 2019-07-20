package com.smart.sperms.service;

import com.smart.sperms.dao.SysMenuDao;
import com.smart.sperms.dao.SysRoleMenuDao;
import com.smart.sperms.dao.dto.SysMenuDto;
import com.smart.sperms.dao.model.SysMenu;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.SysMenuEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.ListQueryWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(SysMenuEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        int menuId = req.getMenuId();
        boolean isExist = this.isExists(menuId);
        if(isExist) {
            wrapper.setResultMsg("该菜单信息已存在");
            return wrapper;
        }
        SysMenu info = new SysMenu();
        info.setMenuIcon(req.getMenuIcon());
        info.setMenuName(req.getMenuName());
        info.setMenuRemark(req.getMenuRemark());
        info.setMenuStatus(req.getMenuStatus());
        info.setMenuUrl(req.getMenuUrl());
        info.setParentId(req.getParentId());
        info.setCreationTime(new Date());

        int cnt = sysMenuDao.saveData(info);
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
    public CommonWrapper updateInfo(SysMenuEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        SysMenu info = new SysMenu();
//        info.setMenuId(req.getMenuId());
        info.setMenuIcon(req.getMenuIcon());
        info.setMenuName(req.getMenuName());
        info.setMenuRemark(req.getMenuRemark());
        info.setMenuStatus(req.getMenuStatus());
        info.setMenuUrl(req.getMenuUrl());
        info.setParentId(req.getParentId());
        info.setModifyTime(new Date());

        int cnt = sysMenuDao.updateData(req.getMenuId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param menuIds
     * @return
     */
    public CommonWrapper deleteInfo(List<Integer> menuIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = sysMenuDao.delData(menuIds);

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

        int total = sysMenuDao.queryPageTotal(beginTime, endTime, keywords);
        List<SysMenu> result = sysMenuDao.queryPage(pageNo, pageSize, beginTime, endTime, keywords);

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

        SysMenu condition = new SysMenu();
        condition.setMenuId(recordId);

        List<SysMenu> result = sysMenuDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 根据角色ID获取菜单列表
     * @param roleId
     * @return
     */
    public ListQueryWrapper findMenusByRoleId(int roleId) {
        ListQueryWrapper wrapper = new ListQueryWrapper();
        List<SysMenuDto> list = sysRoleMenuDao.queryMenusByRoleId(roleId);
        wrapper.setRecords(list);
        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param menuId
     * @return
     */
    private boolean isExists(int menuId) {
        boolean isExist= false;
        SysMenu condition = new SysMenu();
        condition.setMenuId(menuId);

        List<SysMenu> dataList = sysMenuDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
