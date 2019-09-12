package com.smart.sperms.dao.dto;

import java.io.Serializable;

/**
 * 生产统计Dto
 *
 * e_id, e_name, customer_no, customer_name, customer_company, sum(ps_mount) as ps_mount
 */
public class StatProductionMountDto implements Serializable {

    private String eId;

    private String eName;

    private String customerNo;

    private String customerName;

    private String customerCompany;

    private String customerPhone;

    private Double psMount;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

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

    public Double getPsMount() {
        return psMount;
    }

    public void setPsMount(Double psMount) {
        this.psMount = psMount;
    }

    @Override
    public String toString() {
        return "StatsProductionMountDto{" +
                "eId='" + eId + '\'' +
                ", eName='" + eName + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCompany='" + customerCompany + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", psMount=" + psMount +
                '}';
    }
}
