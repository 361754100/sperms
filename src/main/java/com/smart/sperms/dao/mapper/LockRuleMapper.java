package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.LockRule;
import com.smart.sperms.dao.model.LockRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LockRuleMapper {
    int countByExample(LockRuleExample example);

    int deleteByExample(LockRuleExample example);

    int insert(LockRule record);

    int insertSelective(LockRule record);

    List<LockRule> selectByExampleWithRowbounds(LockRuleExample example, RowBounds rowBounds);

    List<LockRule> selectByExample(LockRuleExample example);

    int updateByExampleSelective(@Param("record") LockRule record, @Param("example") LockRuleExample example);

    int updateByExample(@Param("record") LockRule record, @Param("example") LockRuleExample example);
}