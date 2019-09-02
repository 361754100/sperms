package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.dto.RepairDto;
import com.smart.sperms.dao.dto.ScrappDto;
import com.smart.sperms.dao.model.Scrapp;
import com.smart.sperms.dao.model.ScrappExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ScrappMapper {
    int countByExample(ScrappExample example);

    int deleteByExample(ScrappExample example);

    int insert(Scrapp record);

    int insertSelective(Scrapp record);

    List<Scrapp> selectByExampleWithRowbounds(ScrappExample example, RowBounds rowBounds);

    List<Scrapp> selectByExample(ScrappExample example);

    int countByCondition(Map<String, Object> params);

    List<ScrappDto> selectDtoByConditionWithRowbounds(Map<String, Object> params);

    int updateByExampleSelective(@Param("record") Scrapp record, @Param("example") ScrappExample example);

    int updateByExample(@Param("record") Scrapp record, @Param("example") ScrappExample example);
}