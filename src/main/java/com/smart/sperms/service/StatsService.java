package com.smart.sperms.service;

import com.smart.sperms.dao.dto.StatDevStateDto;
import com.smart.sperms.dao.dto.StatDevStateGroupDto;
import com.smart.sperms.dao.dto.StatProductionMountDto;
import com.smart.sperms.dao.dto.StatSalesAccountDto;
import com.smart.sperms.dao.mapper.StatsMapper;
import com.smart.sperms.response.ListQueryWrapper;
import com.smart.sperms.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

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
}
