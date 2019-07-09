package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑客户信息
 */
@ApiModel(description = "客户信息消息体")
public class CustomerEditReq implements Serializable {

    @ApiModelProperty(value = "客户编号")
    private String customerNo;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户性别")
    private String customerSex;

    @ApiModelProperty(value = "客户年龄")
    private Integer customerAge;

    @ApiModelProperty(value = "客户手机")
    private String customerPhone;

    @ApiModelProperty(value = "客户邮箱")
    private String customerEmail;

    @ApiModelProperty(value = "客户地址")
    private String customerAddr;

    @ApiModelProperty(value = "客户单位")
    private String customerCompany;

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

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddr() {
        return customerAddr;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    @Override
    public String toString() {
        return "CustomerEditReq{" +
                "customerNo='" + customerNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSex='" + customerSex + '\'' +
                ", customerAge=" + customerAge +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddr='" + customerAddr + '\'' +
                ", customerCompany='" + customerCompany + '\'' +
                '}';
    }
}
