package com.smart.sperms.dao;

import com.smart.sperms.dao.dto.RentManagerDto;
import com.smart.sperms.dao.mapper.CustomerMapper;
import com.smart.sperms.dao.mapper.RentManagerMapper;
import com.smart.sperms.dao.model.Customer;
import com.smart.sperms.dao.model.RentManagerExample;
import com.smart.sperms.dao.model.RentManager;
import com.smart.sperms.dao.model.RentManagerExample;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RentManagerDao {

    private static final Logger logger = LoggerFactory.getLogger(RentManagerDao.class);

    @Autowired
    private RentManagerMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(RentManager record) {
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
    public int updateData(String recordId, RentManager record) {
        int cnt = 0;
        try {
            RentManagerExample example = new RentManagerExample();
            example.createCriteria().andTradeNoEqualTo(recordId);

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
            RentManagerExample example = new RentManagerExample();
            example.createCriteria().andTradeNoIn(recordIds);

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
     * @param tradeNo
     * @param customerName
     * @param equipmentName
     * @return
     */
    public List<RentManagerDto> queryPage(int pageNo, int pageSize, String beginTime, String endTime,
                                          String tradeNo, String customerName, String equipmentName) {
        int offset = (pageNo-1)*pageSize;

        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("pageSize", pageSize);

        if(!StringUtils.isEmpty(customerName)) {
            params.put("customerName", customerName);
        }
        if(!StringUtils.isEmpty(tradeNo)) {
            params.put("tradeNo", tradeNo);
        }
        if(!StringUtils.isEmpty(equipmentName)) {
            params.put("equipmentName", equipmentName);
        }
        if(!StringUtils.isEmpty(beginTime)) {
            params.put("beginTime", beginTime);
        }
        if(!StringUtils.isEmpty(endTime)) {
            params.put("endTime", endTime);
        }

        List<RentManagerDto> result = mapper.selectDtoByConditionWithRowbounds(params);
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param beginTime
     * @param endTime
     * @param customerName
     * @return
     */
    public int queryPageTotal(String beginTime, String endTime,
                              String tradeNo, String customerName, String equipmentName) {
        Map<String, Object> params = new HashMap<>();

        if(!StringUtils.isEmpty(customerName)) {
            params.put("customerName", customerName);
        }
        if(!StringUtils.isEmpty(tradeNo)) {
            params.put("tradeNo", tradeNo);
        }
        if(!StringUtils.isEmpty(equipmentName)) {
            params.put("equipmentName", equipmentName);
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
    public List<RentManager> queryList(RentManager condition) {
        List<RentManager> result = null;
        RentManagerExample example = new RentManagerExample();
        RentManagerExample.Criteria criteria = example.createCriteria();

        String customerNo = condition.getCustomerNo();
        if(!StringUtils.isEmpty(customerNo)) {
            criteria.andCustomerNoEqualTo(customerNo);
        }

        String tradeNo = condition.getTradeNo();
        if(!StringUtils.isEmpty(tradeNo)) {
            criteria.andTradeNoEqualTo(tradeNo);
        }

        result = mapper.selectByExample(example);
        return result;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<RentManagerDto> queryDtoList(RentManager condition) {
        List<RentManagerDto> result = null;
        Map<String, Object> params = new HashMap<>();
        String tradeNo = condition.getTradeNo();
        if(!StringUtils.isEmpty(tradeNo)) {
            params.put("tradeNo", tradeNo);
        }

        result = mapper.selectDtoByCondition(params);
        return result;
    }
}
