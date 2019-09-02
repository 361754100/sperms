package com.smart.sperms.dao;

import com.smart.sperms.dao.dto.ScrappDto;
import com.smart.sperms.dao.mapper.ScrappMapper;
import com.smart.sperms.dao.model.Repair;
import com.smart.sperms.dao.model.ScrappExample;
import com.smart.sperms.dao.model.Scrapp;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScrappDao {

    private static final Logger logger = LoggerFactory.getLogger(ScrappDao.class);

    @Autowired
    private ScrappMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(Scrapp record) {
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
    public int updateData(String recordId, Scrapp record) {
        int cnt = 0;
        try {
            ScrappExample example = new ScrappExample();
            example.createCriteria().andEIdEqualTo(recordId);

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
    public int delData(List<String> recordIds) {
        int cnt = 0;
        try {
            ScrappExample example = new ScrappExample();
            example.createCriteria().andEIdIn(recordIds);

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
     * @param eName
     * @return
     */
    public List<ScrappDto> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String eName) {
        int offset = (pageNo-1)*pageSize;

        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("pageSize", pageSize);

        if(!StringUtils.isEmpty(eName)) {
            params.put("eName", eName);
        }
        if(!StringUtils.isEmpty(beginTime)) {
            params.put("beginTime", beginTime);
        }
        if(!StringUtils.isEmpty(endTime)) {
            params.put("endTime", endTime);
        }

        List<ScrappDto> result = mapper.selectDtoByConditionWithRowbounds(params);
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param beginTime
     * @param endTime
     * @param eName
     * @return
     */
    public int queryPageTotal(String beginTime, String endTime, String eName) {
        Map<String, Object> params = new HashMap<>();

        if(!StringUtils.isEmpty(eName)) {
            params.put("eName", eName);
        }
        if(!StringUtils.isEmpty(beginTime)) {
            params.put("beginTime", beginTime);
        }
        if(!StringUtils.isEmpty(endTime)) {
            params.put("endTime", endTime);
        }

        int total = mapper.countByCondition(params);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<Scrapp> queryList(Repair condition) {
        List<Scrapp> result = null;
        ScrappExample example = new ScrappExample();
        ScrappExample.Criteria criteria = example.createCriteria();

        String eId = condition.geteId();
        if(!StringUtils.isEmpty(eId)) {
            criteria.andEIdEqualTo(eId);
        }
        result = mapper.selectByExample(example);
        return result;
    }

}
