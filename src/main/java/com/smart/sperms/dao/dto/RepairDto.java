package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.Repair;

/**
 * 维修信息Dto
 */
public class RepairDto extends Repair {

    private String eName;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return "RepairDto{" +
                "eName='" + eName + '\'' +
                '}';
    }
}
