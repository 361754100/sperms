package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.Repair;

/**
 * 维修信息Dto
 */
public class RepairDto extends Repair {

    // 设备名称
    private String eName;
    // 故障名称
    private String errName;
    // 客户名称
    private String customerName;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "RepairDto{" +
                "eName='" + eName + '\'' +
                ", errName='" + errName + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
