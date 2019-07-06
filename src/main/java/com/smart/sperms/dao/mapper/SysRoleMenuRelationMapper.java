package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.SysRoleMenuRelation;
import com.smart.sperms.dao.model.SysRoleMenuRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRoleMenuRelationMapper {
    int countByExample(SysRoleMenuRelationExample example);

    int deleteByExample(SysRoleMenuRelationExample example);

    int insert(SysRoleMenuRelation record);

    int insertSelective(SysRoleMenuRelation record);

    List<SysRoleMenuRelation> selectByExampleWithRowbounds(SysRoleMenuRelationExample example, RowBounds rowBounds);

    List<SysRoleMenuRelation> selectByExample(SysRoleMenuRelationExample example);

    int updateByExampleSelective(@Param("record") SysRoleMenuRelation record, @Param("example") SysRoleMenuRelationExample example);

    int updateByExample(@Param("record") SysRoleMenuRelation record, @Param("example") SysRoleMenuRelationExample example);
}