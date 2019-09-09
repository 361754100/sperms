package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 设备故障信息
 */
@ApiModel(description = "设备故障信息")
public class EquipmentErrCodeEditReq implements Serializable {

    @ApiModelProperty(value = "设备故障号")
    private String errCode;

    @ApiModelProperty(value = "故障名称")
    private String errName;

    @ApiModelProperty(value = "故障描述")
    private String errDesc;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }

    public String getErrDesc() {
        return errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }

    @Override
    public String toString() {
        return "EquipmentErrCodeEditReq{" +
                "errCode='" + errCode + '\'' +
                ", errName='" + errName + '\'' +
                ", errDesc='" + errDesc + '\'' +
                '}';
    }
}
