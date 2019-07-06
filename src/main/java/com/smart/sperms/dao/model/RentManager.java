package com.smart.sperms.dao.model;

import java.io.Serializable;
import java.util.Date;

public class RentManager implements Serializable {
    private String tradeNo;

    private String eId;

    private String customerNo;

    private Date rentDate;

    private Date rentEndDate;

    private String cmNo;

    private String rentPlace;

    private static final long serialVersionUID = 1L;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public String getCmNo() {
        return cmNo;
    }

    public void setCmNo(String cmNo) {
        this.cmNo = cmNo;
    }

    public String getRentPlace() {
        return rentPlace;
    }

    public void setRentPlace(String rentPlace) {
        this.rentPlace = rentPlace;
    }
}