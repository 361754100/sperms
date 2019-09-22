package com.smart.sperms.dao.dto;

import java.io.Serializable;

/**
 * 设备状态统计Dto
 *
 * e_id, e_name, customer_no, customer_name, customer_company, sum(ps_mount) as ps_mount
 */
public class StatDevStateGroupDto implements Serializable {

    private String customerNo;

    private String customerName;

    private String customerCompany;

    private String customerPhone;

    private int normalCount;

    private int repairCount;

    private int scrappCount;

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

    public int getNormalCount() {
        return normalCount;
    }

    public void setNormalCount(int normalCount) {
        this.normalCount = normalCount;
    }

    public int getRepairCount() {
        return repairCount;
    }

    public void setRepairCount(int repairCount) {
        this.repairCount = repairCount;
    }

    public int getScrappCount() {
        return scrappCount;
    }

    public void setScrappCount(int scrappCount) {
        this.scrappCount = scrappCount;
    }

    @Override
    public String toString() {
        return "StatDevStateGroupDto{" +
                "customerNo='" + customerNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCompany='" + customerCompany + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", normalCount=" + normalCount +
                ", repairCount=" + repairCount +
                ", scrappCount=" + scrappCount +
                '}';
    }

}
