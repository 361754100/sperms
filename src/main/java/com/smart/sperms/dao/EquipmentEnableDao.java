package com.smart.sperms.dao;

import com.smart.sperms.dao.dto.EquipmentEnableDto;
import com.smart.sperms.dao.mapper.EquipmentEnableMapper;
import com.smart.sperms.dao.model.EquipmentEnable;
import com.smart.sperms.dao.model.EquipmentEnableExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EquipmentEnableDao {

    private static final Logger logger = LoggerFactory.getLogger(EquipmentEnableDao.class);

    @Autowired
    private EquipmentEnableMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(EquipmentEnable record) {
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
    public int updateData(String recordId, EquipmentEnable record) {
        int cnt = 0;
        try {
            EquipmentEnableExample example = new EquipmentEnableExample();
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
            EquipmentEnableExample example = new EquipmentEnableExample();
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
     * @param e_enable
     * @return
     */
    public List<EquipmentEnableDto> queryPage(int pageNo, int pageSize, int e_enable) {
        int offset = (pageNo-1)*pageSize;

        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        if(e_enable != -1) {
            params.put("eeEnable", e_enable);
        }

        List<EquipmentEnableDto> result = mapper.selectDtoByConditionWithRowbounds(params);
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param e_enable
     * @return
     */
    public int queryPageTotal(int e_enable) {
        Map<String, Object> params = new HashMap<>();
        if(e_enable != -1) {
            params.put("eeEnable", e_enable);
        }

        int total = mapper.countByCondition(params);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<EquipmentEnableDto> queryList(EquipmentEnable condition) {
        List<EquipmentEnableDto> result = null;

        Map<String, Object> params = new HashMap<>();
        if(condition.geteId() != null) {
            params.put("eId", condition.geteId());
        }
        if(condition.getEeEnable() != null && condition.getEeEnable() != -1) {
            params.put("eeEnable", condition.getEeEnable());
        }

        result = mapper.selectDtoByCondition(params);
        return result;
    }

}
