package com.smart.sperms.dao.dto;

import java.io.Serializable;

/**
 * 销售额Dto
 *
 * customer_no, customer_name, customer_company, customer_phone, sum(sales) sales_account
 */
public class StatSalesAccountDto implements Serializable {

    private String customerNo;

    private String customerName;

    private String customerCompany;

    private String customerPhone;

    private Double salesAccount;

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

    public Double getSalesAccount() {
        return salesAccount;
    }

    public void setSalesAccount(Double salesAccount) {
        this.salesAccount = salesAccount;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "StatsSalesAccountDto{" +
                "customerNo='" + customerNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCompany='" + customerCompany + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", salesAccount=" + salesAccount +
                '}';
    }
}
