package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.EquipmentEnable;

/**
 * 设备应用Dto
 */
public class EquipmentEnableDto extends EquipmentEnable {

    private String eName;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return "EquipmentEnableDto{" +
                "eName='" + eName + '\'' +
                '}';
    }
}
