package com.smart.sperms.dao.model;

import java.io.Serializable;

public class UsersCustomerRelation implements Serializable {
    private String uId;

    private String customerNo;

    private static final long serialVersionUID = 1L;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }
}