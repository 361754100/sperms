package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.Product;
import com.smart.sperms.dao.model.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String proId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithRowbounds(ProductExample example, RowBounds rowBounds);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String proId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}