package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.dto.RepairDto;
import com.smart.sperms.dao.model.Repair;
import com.smart.sperms.dao.model.RepairExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface RepairMapper {
    int countByExample(RepairExample example);

    int deleteByExample(RepairExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Repair record);

    int insertSelective(Repair record);

    List<Repair> selectByExampleWithRowbounds(RepairExample example, RowBounds rowBounds);

    int countByCondition(Map<String, Object> params);

    List<RepairDto> selectDtoByConditionWithRowbounds(Map<String, Object> params);

    List<Repair> selectByExample(RepairExample example);

    Repair selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Repair record, @Param("example") RepairExample example);

    int updateByExample(@Param("record") Repair record, @Param("example") RepairExample example);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
}