package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.UsersCustomerRelation;
import com.smart.sperms.dao.model.UsersCustomerRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UsersCustomerRelationMapper {
    int countByExample(UsersCustomerRelationExample example);

    int deleteByExample(UsersCustomerRelationExample example);

    int insert(UsersCustomerRelation record);

    int insertSelective(UsersCustomerRelation record);

    List<UsersCustomerRelation> selectByExampleWithRowbounds(UsersCustomerRelationExample example, RowBounds rowBounds);

    List<UsersCustomerRelation> selectByExample(UsersCustomerRelationExample example);

    int updateByExampleSelective(@Param("record") UsersCustomerRelation record, @Param("example") UsersCustomerRelationExample example);

    int updateByExample(@Param("record") UsersCustomerRelation record, @Param("example") UsersCustomerRelationExample example);
}