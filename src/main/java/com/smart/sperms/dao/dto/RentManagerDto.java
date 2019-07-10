package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.RentManager;

/**
 * 租凭Dto
 */
public class RentManagerDto extends RentManager {

    private String eName;

    private String customerName;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
