package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 编辑租赁信息
 */
@ApiModel(description = "租赁信息消息体")
public class RentManagerEditReq implements Serializable {

    @ApiModelProperty(value = "交易编号")
    private String tradeNo;

    @ApiModelProperty(value = "设备编号")
    private String eId;

    @ApiModelProperty(value = "客户编号")
    private String customerNo;

    @ApiModelProperty(value = "租借时间")
    private String rentDate;

    @ApiModelProperty(value = "租借结束时间")
    private String rentEndDate;

    @ApiModelProperty(value = "计费方式")
    private String cmNo;

    @ApiModelProperty(value = "使用地点")
    private String rentPlace;

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

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
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

    @Override
    public String toString() {
        return "RentManagerEditReq{" +
                "tradeNo='" + tradeNo + '\'' +
                ", eId='" + eId + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", rentDate=" + rentDate +
                ", rentEndDate=" + rentEndDate +
                ", cmNo='" + cmNo + '\'' +
                ", rentPlace='" + rentPlace + '\'' +
                '}';
    }
}
