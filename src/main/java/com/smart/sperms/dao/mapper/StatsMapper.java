package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.dto.StatDevStateDto;
import com.smart.sperms.dao.dto.StatProductionMountDto;
import com.smart.sperms.dao.dto.StatSalesAccountDto;

import java.util.List;
import java.util.Map;

public interface StatsMapper {

    /**
     * 统计销售额
     * @param params
     * @return
     */
    List<StatSalesAccountDto> statSalesAccount(Map<String, Object> params);

    /**
     * 统计产量
     * @param params
     * @return
     */
    List<StatProductionMountDto> statProductMount(Map<String, Object> params);

    /**
     * 统计设备状态
     * @param params
     * @return
     */
    List<StatDevStateDto> statDevState(Map<String, Object> params);
}