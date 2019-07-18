package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.dto.EquipmentEnableDto;
import com.smart.sperms.dao.model.EquipmentEnable;
import com.smart.sperms.dao.model.EquipmentEnableExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EquipmentEnableMapper {
    int countByExample(EquipmentEnableExample example);

    int deleteByExample(EquipmentEnableExample example);

    int insert(EquipmentEnable record);

    int insertSelective(EquipmentEnable record);

    List<EquipmentEnable> selectByExampleWithRowbounds(EquipmentEnableExample example, RowBounds rowBounds);

    List<EquipmentEnable> selectByExample(EquipmentEnableExample example);

    int updateByExampleSelective(@Param("record") EquipmentEnable record, @Param("example") EquipmentEnableExample example);

    int updateByExample(@Param("record") EquipmentEnable record, @Param("example") EquipmentEnableExample example);

    List<EquipmentEnableDto> selectDtoByConditionWithRowbounds(Map<String, Object> params);

    List<EquipmentEnableDto> selectDtoByCondition(Map<String, Object> params);

    int countByCondition(Map<String, Object> params);
}