package com.smart.sperms.service;

import com.smart.sperms.dao.dto.StatDevStateDto;
import com.smart.sperms.dao.dto.StatProductionMountDto;
import com.smart.sperms.dao.dto.StatSalesAccountDto;
import com.smart.sperms.dao.mapper.StatsMapper;
import com.smart.sperms.response.ListQueryWrapper;
import com.smart.sperms.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatsService {

    @Autowired
    private StatsMapper statsMapper;

    /**
     * 统计销售额
     * @param beginTime
     * @param endTime
     * @return
     */
    public ListQueryWrapper salesAccount(String beginTime, String endTime) {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        Map<String, Object> params = new HashMap<>();
        if(!StringUtils.isEmpty(beginTime) && !StringUtils.isEmpty(endTime)) {
            params.put("beginTime", beginTime);
            params.put("endTime", endTime);
        }
        List<StatSalesAccountDto> result = statsMapper.statSalesAccount(params);
        wrapper.setRecords(result);
        return wrapper;
    }

    /**
     * 统计销售额
     * @param beginTime
     * @param endTime
     * @return
     */
    public ListQueryWrapper produceMount(String beginTime, String endTime, String customerNo, String customerName) {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        Map<String, Object> params = new HashMap<>();
        if(!StringUtils.isEmpty(beginTime) && !StringUtils.isEmpty(endTime)) {
            params.put("beginTime", beginTime);
            params.put("endTime", endTime);
        }
        if(!StringUtils.isEmpty(customerNo)) {
            params.put("customerNo", customerNo);
        }
        if(!StringUtils.isEmpty(customerName)) {
            params.put("customerName", customerName);
        }

        List<StatProductionMountDto> result = statsMapper.statProductMount(params);
        wrapper.setRecords(result);
        return wrapper;
    }

    /**
     * 统计销售额
     * @param beginTime
     * @param endTime
     * @return
     */
    public ListQueryWrapper devStateAccount(String beginTime, String endTime) {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        Map<String, Object> params = new HashMap<>();
        if(!StringUtils.isEmpty(beginTime) && !StringUtils.isEmpty(endTime)) {
            params.put("beginTime", beginTime);
            params.put("endTime", endTime);
        }

        List<StatDevStateDto> result = statsMapper.statDevState(params);
        wrapper.setRecords(result);
        return wrapper;
    }
}
