package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.dto.MonitorPicDto;
import com.smart.sperms.dao.model.MonitorPic;
import com.smart.sperms.dao.model.MonitorPicExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface MonitorPicMapper {
    int countByExample(MonitorPicExample example);

    int deleteByExample(MonitorPicExample example);

    int deleteByPrimaryKey(Integer picId);

    int insert(MonitorPic record);

    int insertSelective(MonitorPic record);

    List<MonitorPic> selectByExampleWithRowbounds(MonitorPicExample example, RowBounds rowBounds);

    List<MonitorPic> selectByExample(MonitorPicExample example);

    MonitorPic selectByPrimaryKey(Integer picId);

    int updateByExampleSelective(@Param("record") MonitorPic record, @Param("example") MonitorPicExample example);

    int updateByExample(@Param("record") MonitorPic record, @Param("example") MonitorPicExample example);

    int updateByPrimaryKeySelective(MonitorPic record);

    int updateByPrimaryKey(MonitorPic record);

    List<MonitorPicDto> selectDtoByConditionWithRowbounds(Map<String, Object> params);

    List<MonitorPicDto> selectDtoByCondition(Map<String, Object> params);

    int countByCondition(Map<String, Object> params);
}