package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑租赁信息
 */
@ApiModel(description = "租赁信息消息体")
public class RentManagerAddReq implements Serializable {

    @ApiModelProperty(value = "设备编号")
    private String eId;

    @ApiModelProperty(value = "客户编号")
    private String customerNo;

    @ApiModelProperty(value = "租借开始时间")
    private String rentBeginDate;

    @ApiModelProperty(value = "租借时间")
    private String rentDate;

    @ApiModelProperty(value = "租借结束时间")
    private String rentEndDate;

    @ApiModelProperty(value = "计费方式")
    private String cmNo;

    @ApiModelProperty(value = "使用地点")
    private String rentPlace;

    @ApiModelProperty(value = "是否启动自动锁机策略，0：不启动；1：启动；启动后，同时会检查结束时间，进行确认是否自动锁机")
    private Integer autoLock;

    @ApiModelProperty(value = "产量总额（达标锁机），0为无限量")
    private Integer lrMount;

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

    public String getRentBeginDate() {
        return rentBeginDate;
    }

    public void setRentBeginDate(String rentBeginDate) {
        this.rentBeginDate = rentBeginDate;
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

    public Integer getAutoLock() {
        return autoLock;
    }

    public void setAutoLock(Integer autoLock) {
        this.autoLock = autoLock;
    }

    public Integer getLrMount() {
        return lrMount;
    }

    public void setLrMount(Integer lrMount) {
        this.lrMount = lrMount;
    }

    @Override
    public String toString() {
        return "RentManagerEditReq{" +
                " eId='" + eId + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", rentBeginDate='" + rentBeginDate + '\'' +
                ", rentDate='" + rentDate + '\'' +
                ", rentEndDate='" + rentEndDate + '\'' +
                ", cmNo='" + cmNo + '\'' +
                ", rentPlace='" + rentPlace + '\'' +
                ", autoLock=" + autoLock +
                ", lrMount=" + lrMount +
                '}';
    }
}
