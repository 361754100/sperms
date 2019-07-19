package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.SysRoleMapper;
import com.smart.sperms.dao.model.SysRole;
import com.smart.sperms.dao.model.SysRoleExample;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysRoleMenuDao {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleMenuDao.class);

    @Autowired
    private SysRoleMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(SysRole record) {
        int cnt = 0;
        try {
            cnt = mapper.insertSelective(record);
        } catch (Exception e) {
            logger.error("save data error...", e);
        }
        return cnt;
    }

    /**
     * 修改记录
     * @param recordId
     * @param record
     * @return
     */
    public int updateData(Integer recordId, SysRole record) {
        int cnt = 0;
        try {
            SysRoleExample example = new SysRoleExample();
            example.createCriteria().andRoleIdEqualTo(recordId);

            cnt = mapper.updateByExampleSelective(record, example);
        } catch (Exception e) {
            logger.error("update data error...", e);
        }
        return cnt;
    }

    /**
     * 删除记录
     * @param recordIds
     * @return
     */
    public int delData(List<Integer> recordIds) {
        int cnt = 0;
        try {
            SysRoleExample example = new SysRoleExample();
            example.createCriteria().andRoleIdIn(recordIds);

            cnt = mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("delete data error...", e);
        }
        return cnt;
    }

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param beginTime
     * @param endTime
     * @param keywords
     * @return
     */
    public List<SysRole> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String keywords) {
        int offset = (pageNo-1)*pageSize;
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(keywords)) {
            criteria.andRoleNameLike("%" + keywords + "%");
        }
        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }

        List<SysRole> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param beginTime
     * @param endTime
     * @param keywords
     * @return
     */
    public int queryPageTotal(String beginTime, String endTime, String keywords) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(keywords)) {
            criteria.andRoleNameLike("%" + keywords + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<SysRole> queryList(SysRole condition) {
        List<SysRole> result = null;
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();

        int roleId = condition.getRoleId();
//        if(!StringUtils.isEmpty(menuId)) {
            criteria.andRoleIdEqualTo(roleId);
//        }
        result = mapper.selectByExample(example);
        return result;
    }

}
