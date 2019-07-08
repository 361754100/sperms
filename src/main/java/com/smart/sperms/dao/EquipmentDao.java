package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.EquipmentMapper;
import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.dao.model.EquipmentExample;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentDao {

    private static final Logger logger = LoggerFactory.getLogger(EquipmentDao.class);

    @Autowired
    private EquipmentMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(Equipment record) {
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
    public int updateData(String recordId, Equipment record) {
        int cnt = 0;
        try {
            EquipmentExample example = new EquipmentExample();
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
            EquipmentExample example = new EquipmentExample();
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
    public List<Equipment> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String eName) {
        int offset = (pageNo-1)*pageSize;
        EquipmentExample example = new EquipmentExample();
        EquipmentExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(eName)) {
            criteria.andENameLike("%" + eName + "%");
        }
        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andEDateGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andEDateLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }

        List<Equipment> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
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
        EquipmentExample example = new EquipmentExample();
        EquipmentExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andEDateGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andEDateLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(eName)) {
            criteria.andENameLike("%" + eName + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<Equipment> queryList(Equipment condition) {
        List<Equipment> result = null;
        EquipmentExample example = new EquipmentExample();
        EquipmentExample.Criteria criteria = example.createCriteria();

        String eId = condition.geteId();
        if(!StringUtils.isEmpty(eId)) {
            criteria.andEIdEqualTo(eId);
        }
        result = mapper.selectByExample(example);
        return result;
    }

}
