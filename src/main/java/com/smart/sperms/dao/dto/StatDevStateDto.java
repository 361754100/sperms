package com.smart.sperms.dao.dto;

import java.io.Serializable;

/**
 * 生产统计Dto
 *
 * e_id, e_name, customer_no, customer_name, customer_company, sum(ps_mount) as ps_mount
 */
public class StatDevStateDto implements Serializable {

    private String customerNo;

    private String customerName;

    private String customerCompany;

    private String customerPhone;

    private Integer devCount;

    private Integer countType;

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getDevCount() {
        return devCount;
    }

    public void setDevCount(Integer devCount) {
        this.devCount = devCount;
    }

    public Integer getCountType() {
        return countType;
    }

    public void setCountType(Integer countType) {
        this.countType = countType;
    }

    @Override
    public String toString() {
        return "StatDevStateDto{" +
                "customerNo='" + customerNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCompany='" + customerCompany + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", devCount=" + devCount +
                ", countType=" + countType +
                '}';
    }
}
