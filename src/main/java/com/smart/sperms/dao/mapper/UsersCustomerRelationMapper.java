package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.Customer;
import com.smart.sperms.dao.model.Users;
import com.smart.sperms.dao.model.UsersCustomerRelation;
import com.smart.sperms.dao.model.UsersCustomerRelationExample;
import java.util.List;
import java.util.Map;

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

    List<Users> selectUserByCustomerNo(Map<String, Object> params);

    List<Customer> selectCustomerByUid(Map<String, Object> params);
}