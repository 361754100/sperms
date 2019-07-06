package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 编辑设备信息
 */
@ApiModel(description = "设备信息消息体")
public class EquipmentEditReq implements Serializable {

    @ApiModelProperty(value = "设备ID")
    private String eId;

    @ApiModelProperty(value = "设备名称")
    private String eName;

    @ApiModelProperty(value = "规格")
    private String eStandard;

    @ApiModelProperty(value = "生产厂家")
    private String eManufacturer;

    @ApiModelProperty(value = "类型")
    private String eType;

    @ApiModelProperty(value = "生产日期 yyyy-MM-dd HH:mm:ss")
    private String eDate;

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

    public String geteStandard() {
        return eStandard;
    }

    public void seteStandard(String eStandard) {
        this.eStandard = eStandard;
    }

    public String geteManufacturer() {
        return eManufacturer;
    }

    public void seteManufacturer(String eManufacturer) {
        this.eManufacturer = eManufacturer;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    @Override
    public String toString() {
        return "EquipmentEditReq{" +
                "eId='" + eId + '\'' +
                ", eName='" + eName + '\'' +
                ", eStandard='" + eStandard + '\'' +
                ", eManufacturer='" + eManufacturer + '\'' +
                ", eType='" + eType + '\'' +
                ", eDate='" + eDate + '\'' +
                '}';
    }
}
