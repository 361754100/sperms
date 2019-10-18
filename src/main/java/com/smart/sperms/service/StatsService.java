package com.smart.sperms.service;

import com.smart.sperms.dao.dto.*;
import com.smart.sperms.dao.mapper.StatsMapper;
import com.smart.sperms.enums.StatTypeEnum;
import com.smart.sperms.response.ListQueryWrapper;
import com.smart.sperms.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
     * 设备状态统计
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
        Map<String, StatDevStateGroupDto> stateGroupDtoMap = new HashMap<>();
        List<StatDevStateDto> result = statsMapper.statDevState(params);
        String custNo = null;
        StatDevStateGroupDto stateGroupDto = null;
        for(StatDevStateDto stateDto:result) {
            custNo = stateDto.getCustomerNo();
            if(StringUtils.isEmpty(custNo)) {
                continue;
            }
            stateGroupDto = stateGroupDtoMap.get(custNo);
            if(stateGroupDto == null) {
                stateGroupDto = new StatDevStateGroupDto();
            }
            stateGroupDto.setCustomerCompany(stateDto.getCustomerCompany());
            stateGroupDto.setCustomerName(stateDto.getCustomerName());
            stateGroupDto.setCustomerPhone(stateDto.getCustomerPhone());
            stateGroupDto.setCustomerNo(custNo);

            int countType = stateDto.getCountType();
            switch (countType) {
                case 0:
                    stateGroupDto.setNormalCount(stateDto.getDevCount());
                    break;
                case 1:
                    stateGroupDto.setRepairCount(stateDto.getDevCount());
                    break;
                case 2:
                    stateGroupDto.setScrappCount(stateDto.getDevCount());
                    break;
            }
            stateGroupDtoMap.put(custNo, stateGroupDto);
        }

        List<StatDevStateGroupDto> groupList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(stateGroupDtoMap)) {
            for(Map.Entry<String, StatDevStateGroupDto> entry : stateGroupDtoMap.entrySet()) {
                groupList.add(entry.getValue());
            }
        }
        wrapper.setRecords(groupList);
        return wrapper;
    }

    /**
     * 产量统计
     * @param beginTime
     * @param endTime
     * @return
     */
    public ListQueryWrapper prodMount(int statType, String beginTime,
                                         String endTime, String customerNo,
                                         String eId) {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        Map<String, Object> params = new HashMap<>();
        if(!StringUtils.isEmpty(beginTime) && !StringUtils.isEmpty(endTime)) {
            params.put("beginTime", beginTime);
            params.put("endTime", endTime);
        }
        if(!StringUtils.isEmpty(customerNo)) {
            params.put("customerNo", customerNo);
        }
        if(!StringUtils.isEmpty(eId)) {
            params.put("eId", eId);
        }

        List<StatProdMountDto> result = new ArrayList<>();
        StatTypeEnum statTypeEnum = StatTypeEnum.getType(statType);
        switch (statTypeEnum) {
            case UNKNOW:
                break;
            case BY_DAY:
                result = statsMapper.statProdMountByDay(params);
                break;
            case BY_MONTH:
                result = statsMapper.statProdMountByMonth(params);
                break;
        }
        wrapper.setRecords(result);
        return wrapper;
    }

    /**
     * 产品类型的产量统计
     * @param statType      统计方式（1：按天，2：按月）
     * @param beginTime     开始时间
     * @param endTime       结束时间
     * @param customerNo    客户编号
     * @param eId           设备编号
     * @return
     */
    public ListQueryWrapper prodMountByType(int statType, String beginTime,
                                            String endTime, String customerNo,
                                            String eId) {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        Map<String, Object> params = new HashMap<>();
        if(!StringUtils.isEmpty(beginTime) && !StringUtils.isEmpty(endTime)) {
            params.put("beginTime", beginTime);
            params.put("endTime", endTime);
        }
        if(!StringUtils.isEmpty(customerNo)) {
            params.put("customerNo", customerNo);
        }
        if(!StringUtils.isEmpty(eId)) {
            params.put("eId", eId);
        }

        List<StatProdMountByTypeDto> result = new ArrayList<>();
                StatTypeEnum statTypeEnum = StatTypeEnum.getType(statType);
        switch (statTypeEnum) {
            case UNKNOW:
                break;
            case BY_DAY:
                result = statsMapper.statProdTypeMountByDay(params);
                break;
            case BY_MONTH:
                result = statsMapper.statProdTypeMountByMonth(params);
                break;
        }
        wrapper.setRecords(result);
        return wrapper;
    }
}
