package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 设备应用信息
 */
@ApiModel(description = "设备应用信息消息体")
public class EquipmentEnableEditReq implements Serializable {

    @ApiModelProperty(value = "设备ID")
    private String eId;

    @ApiModelProperty(value = "应用授权（0：关停；1：正常使用）")
    private Integer eeEnable;

    @ApiModelProperty(value = "状况")
    private String eeCondition;

    @ApiModelProperty(value = "GPS经度")
    private String eeLongitude;

    @ApiModelProperty(value = "GPS纬度")
    private String eeLatitude;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public Integer getEeEnable() {
        return eeEnable;
    }

    public void setEeEnable(Integer eeEnable) {
        this.eeEnable = eeEnable;
    }

    public String getEeCondition() {
        return eeCondition;
    }

    public void setEeCondition(String eeCondition) {
        this.eeCondition = eeCondition;
    }

    public String getEeLongitude() {
        return eeLongitude;
    }

    public void setEeLongitude(String eeLongitude) {
        this.eeLongitude = eeLongitude;
    }

    public String getEeLatitude() {
        return eeLatitude;
    }

    public void setEeLatitude(String eeLatitude) {
        this.eeLatitude = eeLatitude;
    }

    @Override
    public String toString() {
        return "EquipmentEnableEditReq{" +
                "eId='" + eId + '\'' +
                ", eeEnable=" + eeEnable +
                ", eeCondition='" + eeCondition + '\'' +
                ", eeLongitude='" + eeLongitude + '\'' +
                ", eeLatitude='" + eeLatitude + '\'' +
                '}';
    }
}
