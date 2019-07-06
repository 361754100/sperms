package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.ProductionStat;
import com.smart.sperms.dao.model.ProductionStatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProductionStatMapper {
    int countByExample(ProductionStatExample example);

    int deleteByExample(ProductionStatExample example);

    int insert(ProductionStat record);

    int insertSelective(ProductionStat record);

    List<ProductionStat> selectByExampleWithRowbounds(ProductionStatExample example, RowBounds rowBounds);

    List<ProductionStat> selectByExample(ProductionStatExample example);

    int updateByExampleSelective(@Param("record") ProductionStat record, @Param("example") ProductionStatExample example);

    int updateByExample(@Param("record") ProductionStat record, @Param("example") ProductionStatExample example);
}