package com.smart.sperms.dao;

import com.smart.sperms.dao.dto.ProductionStatDto;
import com.smart.sperms.dao.mapper.ProductionStatMapper;
import com.smart.sperms.dao.model.ProductionStat;
import com.smart.sperms.dao.model.ProductionStatExample;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductionStatDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductionStatDao.class);

    @Autowired
    private ProductionStatMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(ProductionStat record) {
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
    public int updateData(String recordId, ProductionStat record) {
        int cnt = 0;
        try {
            ProductionStatExample example = new ProductionStatExample();
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
            ProductionStatExample example = new ProductionStatExample();
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
     * @param eName
     * @return
     */
    public List<ProductionStatDto> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String eName) {
        int offset = (pageNo-1)*pageSize;

        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        params.put("beginTime", beginTime);
        params.put("endTime", endTime);
        if(!StringUtils.isEmpty(eName)) {
            params.put("eName", eName);
        }

        List<ProductionStatDto> result = mapper.selectDtoByConditionWithRowbounds(params);
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
        params.put("beginTime", beginTime);
        params.put("endTime", endTime);
        if(!StringUtils.isEmpty(eName)) {
            params.put("eName", eName);
        }

        int total = mapper.countByCondition(params);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<ProductionStatDto> queryList(ProductionStatDto condition) {
        List<ProductionStatDto> result = null;

        Map<String, Object> params = new HashMap<>();
        if(condition.geteId() != null) {
            params.put("eId", condition.geteId());
        }
        if(condition.geteName() != null ) {
            params.put("eName", condition.geteName());
        }

        result = mapper.selectDtoByCondition(params);
        return result;
    }

}
