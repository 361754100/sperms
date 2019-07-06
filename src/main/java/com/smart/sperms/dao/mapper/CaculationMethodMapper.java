package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.CaculationMethod;
import com.smart.sperms.dao.model.CaculationMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CaculationMethodMapper {
    int countByExample(CaculationMethodExample example);

    int deleteByExample(CaculationMethodExample example);

    int deleteByPrimaryKey(String cmNo);

    int insert(CaculationMethod record);

    int insertSelective(CaculationMethod record);

    List<CaculationMethod> selectByExampleWithRowbounds(CaculationMethodExample example, RowBounds rowBounds);

    List<CaculationMethod> selectByExample(CaculationMethodExample example);

    CaculationMethod selectByPrimaryKey(String cmNo);

    int updateByExampleSelective(@Param("record") CaculationMethod record, @Param("example") CaculationMethodExample example);

    int updateByExample(@Param("record") CaculationMethod record, @Param("example") CaculationMethodExample example);

    int updateByPrimaryKeySelective(CaculationMethod record);

    int updateByPrimaryKey(CaculationMethod record);
}