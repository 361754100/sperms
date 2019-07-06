package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.RentManager;
import com.smart.sperms.dao.model.RentManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RentManagerMapper {
    int countByExample(RentManagerExample example);

    int deleteByExample(RentManagerExample example);

    int deleteByPrimaryKey(String tradeNo);

    int insert(RentManager record);

    int insertSelective(RentManager record);

    List<RentManager> selectByExampleWithRowbounds(RentManagerExample example, RowBounds rowBounds);

    List<RentManager> selectByExample(RentManagerExample example);

    RentManager selectByPrimaryKey(String tradeNo);

    int updateByExampleSelective(@Param("record") RentManager record, @Param("example") RentManagerExample example);

    int updateByExample(@Param("record") RentManager record, @Param("example") RentManagerExample example);

    int updateByPrimaryKeySelective(RentManager record);

    int updateByPrimaryKey(RentManager record);
}