package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.dto.RentManagerDto;
import com.smart.sperms.dao.model.RentManager;
import com.smart.sperms.dao.model.RentManagerExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RentManagerMapper {
    int countByExample(RentManagerExample example);

    int countByCondition(Map<String, Object> params);

    int deleteByExample(RentManagerExample example);

    int deleteByPrimaryKey(String tradeNo);

    int insert(RentManager record);

    int insertSelective(RentManager record);

    List<RentManager> selectByExampleWithRowbounds(RentManagerExample example, RowBounds rowBounds);

    List<RentManagerDto> selectDtoByConditionWithRowbounds(Map<String, Object> params);

    List<RentManagerDto> selectDtoByCondition(Map<String, Object> params);

    List<RentManager> selectByExample(RentManagerExample example);

    RentManager selectByPrimaryKey(String tradeNo);

    int updateByExampleSelective(@Param("record") RentManager record, @Param("example") RentManagerExample example);

    int updateByExample(@Param("record") RentManager record, @Param("example") RentManagerExample example);

    int updateByPrimaryKeySelective(RentManager record);

    int updateByPrimaryKey(RentManager record);
}