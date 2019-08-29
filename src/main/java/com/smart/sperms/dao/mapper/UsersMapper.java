package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.dto.UsersDto;
import com.smart.sperms.dao.model.Users;
import com.smart.sperms.dao.model.UsersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UsersMapper {
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(String uId);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExampleWithRowbounds(UsersExample example, RowBounds rowBounds);

    List<UsersDto> selectDtoByConditionWithRowbounds(Map<String, Object> params);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(String uId);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}