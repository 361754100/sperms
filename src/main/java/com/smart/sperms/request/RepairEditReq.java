package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑设备维修信息
 */
@ApiModel(description = "设备维修消息体")
public class RepairEditReq implements Serializable {

    @ApiModelProperty(value = "流水号")
    private int id;

    @ApiModelProperty(value = "维修厂家")
    private String rManufacturer;

    @ApiModelProperty(value = "维修状态")
    private String rState;

    @ApiModelProperty(value = "维修费用")
    private Double rCost;

    @ApiModelProperty(value = "维修负责人")
    private String rPerson;

    @ApiModelProperty(value = "故障编码")
    private String errCode;

    @ApiModelProperty(value = "维修时间")
    private String rTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getrManufacturer() {
        return rManufacturer;
    }

    public void setrManufacturer(String rManufacturer) {
        this.rManufacturer = rManufacturer;
    }

    public String getrState() {
        return rState;
    }

    public void setrState(String rState) {
        this.rState = rState;
    }

    public Double getrCost() {
        return rCost;
    }

    public void setrCost(Double rCost) {
        this.rCost = rCost;
    }

    public String getrPerson() {
        return rPerson;
    }

    public void setrPerson(String rPerson) {
        this.rPerson = rPerson;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    @Override
    public String toString() {
        return "RepairEditReq{" +
                "id='" + id + '\'' +
                ", rManufacturer='" + rManufacturer + '\'' +
                ", rState='" + rState + '\'' +
                ", rCost=" + rCost +
                ", rPerson='" + rPerson + '\'' +
                ", errCode='" + errCode + '\'' +
                ", rTime='" + rTime + '\'' +
                '}';
    }
}
