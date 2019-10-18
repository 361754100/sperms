package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.dto.StatDevStateDto;
import com.smart.sperms.dao.dto.StatProdMountByTypeDto;
import com.smart.sperms.dao.dto.StatProdMountDto;
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
    List<StatProdMountDto> statProductMount(Map<String, Object> params);

    /**
     * 统计设备状态
     * @param params
     * @return
     */
    List<StatDevStateDto> statDevState(Map<String, Object> params);

    /**
     * 产量统计（按日）
     * @param params
     * @return
     */
    List<StatProdMountDto> statProdMountByDay(Map<String, Object> params);

    /**
     * 产量统计（按月）
     * @param params
     * @return
     */
    List<StatProdMountDto> statProdMountByMonth(Map<String, Object> params);

    /**
     * 产品类型产量统计（按日）
     * @param params
     * @return
     */
    List<StatProdMountByTypeDto> statProdTypeMountByDay(Map<String, Object> params);

    /**
     * 产品类型产量统计（按月）
     * @param params
     * @return
     */
    List<StatProdMountByTypeDto> statProdTypeMountByMonth(Map<String, Object> params);
}