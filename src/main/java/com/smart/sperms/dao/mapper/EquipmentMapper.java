package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.dao.model.EquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EquipmentMapper {
    int countByExample(EquipmentExample example);

    int deleteByExample(EquipmentExample example);

    int deleteByPrimaryKey(String eId);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExampleWithRowbounds(EquipmentExample example, RowBounds rowBounds);

    List<Equipment> selectByExample(EquipmentExample example);

    Equipment selectByPrimaryKey(String eId);

    int updateByExampleSelective(@Param("record") Equipment record, @Param("example") EquipmentExample example);

    int updateByExample(@Param("record") Equipment record, @Param("example") EquipmentExample example);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}