package com.smart.sperms.dao.mapper;

import com.smart.sperms.dao.model.EquipmentErrCode;
import com.smart.sperms.dao.model.EquipmentErrCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EquipmentErrCodeMapper {
    int countByExample(EquipmentErrCodeExample example);

    int deleteByExample(EquipmentErrCodeExample example);

    int deleteByPrimaryKey(String errCode);

    int insert(EquipmentErrCode record);

    int insertSelective(EquipmentErrCode record);

    List<EquipmentErrCode> selectByExampleWithRowbounds(EquipmentErrCodeExample example, RowBounds rowBounds);

    List<EquipmentErrCode> selectByExample(EquipmentErrCodeExample example);

    EquipmentErrCode selectByPrimaryKey(String errCode);

    int updateByExampleSelective(@Param("record") EquipmentErrCode record, @Param("example") EquipmentErrCodeExample example);

    int updateByExample(@Param("record") EquipmentErrCode record, @Param("example") EquipmentErrCodeExample example);

    int updateByPrimaryKeySelective(EquipmentErrCode record);

    int updateByPrimaryKey(EquipmentErrCode record);
}