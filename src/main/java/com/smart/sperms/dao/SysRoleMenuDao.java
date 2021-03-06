package com.smart.sperms.dao;

import com.smart.sperms.dao.dto.SysMenuDto;
import com.smart.sperms.dao.mapper.SysRoleMenuRelationMapper;
import com.smart.sperms.dao.model.SysRoleMenuRelation;
import com.smart.sperms.dao.model.SysRoleMenuRelationExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SysRoleMenuDao {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleMenuDao.class);

    @Autowired
    private SysRoleMenuRelationMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(SysRoleMenuRelation record) {
        int cnt = 0;
        try {
            cnt = mapper.insertSelective(record);
        } catch (Exception e) {
            logger.error("save data error...", e);
        }
        return cnt;
    }

    /**
     * 删除角色菜单关联记录
     * @param roleIds
     * @return
     */
    public int delRelationByRoleIds(List<Integer> roleIds) {
        int cnt = 0;
        try {
            SysRoleMenuRelationExample example = new SysRoleMenuRelationExample();
            example.createCriteria().andRoleIdIn(roleIds);

            cnt = mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("delete data error...", e);
        }
        return cnt;
    }

    /**
     * 删除角色菜单关联记录
     * @param roleId
     * @return
     */
    public int delRelationByRoleId(Integer roleId) {
        int cnt = 0;
        try {
            SysRoleMenuRelationExample example = new SysRoleMenuRelationExample();
            example.createCriteria().andRoleIdEqualTo(roleId);

            cnt = mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("delete data error...", e);
        }
        return cnt;
    }

    /**
     * 删除角色菜单关联关系
     * @param roleId
     * @param menuIds
     * @return
     */
    public int delRelationByRoleMenuId(int roleId, List<Integer> menuIds) {
        int cnt = 0;
        try {
            SysRoleMenuRelationExample example = new SysRoleMenuRelationExample();
            example.createCriteria().andRoleIdEqualTo(roleId).andMenuIdIn(menuIds);

            cnt = mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("delete data error...", e);
        }
        return cnt;
    }

    /**
     * 根据角色ID查询菜单列表
     * @param roleId
     * @return
     */
    public List<SysMenuDto> queryMenusByRoleId(int roleId) {
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", roleId);

        List<SysMenuDto> menuDtos = mapper.selectMenuDtoByRoleId(params);
        return menuDtos;
    }

    /**
     * 判断关系是否存在
     * @param roleId
     * @param menuId
     * @return
     */
    public boolean isRelationExists(int roleId, int menuId) {
        boolean isExists = false;
        SysRoleMenuRelationExample example = new SysRoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId).andMenuIdEqualTo(menuId);

        List<SysRoleMenuRelation> result = mapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(result)) {
            isExists = true;
        }
        return isExists;
    }

}
