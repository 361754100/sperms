package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.SysMenuMapper;
import com.smart.sperms.dao.model.SysMenu;
import com.smart.sperms.dao.model.SysMenuExample;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysMenuDao {

    private static final Logger logger = LoggerFactory.getLogger(SysMenuDao.class);

    @Autowired
    private SysMenuMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(SysMenu record) {
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
    public int updateData(Integer recordId, SysMenu record) {
        int cnt = 0;
        try {
            SysMenuExample example = new SysMenuExample();
            example.createCriteria().andMenuIdEqualTo(recordId);

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
            SysMenuExample example = new SysMenuExample();
            example.createCriteria().andMenuIdIn(recordIds);

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
    public List<SysMenu> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String keywords) {
        int offset = (pageNo-1)*pageSize;
        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(keywords)) {
            criteria.andMenuNameLike("%" + keywords + "%");
        }
        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }

        List<SysMenu> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
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
        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(keywords)) {
            criteria.andMenuNameLike("%" + keywords + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<SysMenu> queryList(SysMenu condition) {
        List<SysMenu> result = null;
        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();

        Integer menuId = condition.getMenuId();
        if(menuId !=null ) {
            criteria.andMenuIdEqualTo(menuId);
        }
        if(!StringUtils.isEmpty(condition.getMenuName())) {
            criteria.andMenuNameLike("%" + condition.getMenuName() + "%");
        }
        result = mapper.selectByExample(example);
        return result;
    }

}
