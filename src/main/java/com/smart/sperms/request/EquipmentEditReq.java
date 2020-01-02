package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

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

    @ApiModelProperty(value = "应用授权（0：关停；1：正常使用）")
    private Integer eEnable;

    @ApiModelProperty(value = "类型")
    private String eType;

    @ApiModelProperty(value = "GPS经度")
    private String eLongitude;

    @ApiModelProperty(value = "GPS纬度")
    private String eLatitude;

    @ApiModelProperty(value = "生产日期 yyyy-MM-dd HH:mm:ss")
    private String eDate;

    @ApiModelProperty(value = "modbux数据类型-安卓端")
    private int androidAddress;

    @ApiModelProperty(value = "modbux从站地址-安卓端")
    private int androidSlaveAddress;

    @ApiModelProperty(value = "信号类型（1：表示只有0/1信号类型，2：表示可以传输一个Byte类型）-安卓端")
    private int androidType;

    @ApiModelProperty(value = "密钥-安卓端")
    private String androidPwd;

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

    public String geteLongitude() {
        return eLongitude;
    }

    public void seteLongitude(String eLongitude) {
        this.eLongitude = eLongitude;
    }

    public String geteLatitude() {
        return eLatitude;
    }

    public void seteLatitude(String eLatitude) {
        this.eLatitude = eLatitude;
    }

    public Integer geteEnable() {
        return eEnable;
    }

    public void seteEnable(Integer eEnable) {
        this.eEnable = eEnable;
    }

    public int getAndroidAddress() {
        return androidAddress;
    }

    public void setAndroidAddress(int androidAddress) {
        this.androidAddress = androidAddress;
    }

    public int getAndroidType() {
        return androidType;
    }

    public void setAndroidType(int androidType) {
        this.androidType = androidType;
    }

    public String getAndroidPwd() {
        return androidPwd;
    }

    public void setAndroidPwd(String androidPwd) {
        this.androidPwd = androidPwd;
    }

    public int getAndroidSlaveAddress() {
        return androidSlaveAddress;
    }

    public void setAndroidSlaveAddress(int androidSlaveAddress) {
        this.androidSlaveAddress = androidSlaveAddress;
    }

    @Override
    public String toString() {
        return "EquipmentEditReq{" +
                "eId='" + eId + '\'' +
                ", eName='" + eName + '\'' +
                ", eStandard='" + eStandard + '\'' +
                ", eManufacturer='" + eManufacturer + '\'' +
                ", eEnable=" + eEnable +
                ", eType='" + eType + '\'' +
                ", eLongitude='" + eLongitude + '\'' +
                ", eLatitude='" + eLatitude + '\'' +
                ", eDate='" + eDate + '\'' +
                ", androidAddress=" + androidAddress +
                ", androidSlaveAddress=" + androidSlaveAddress +
                ", androidType=" + androidType +
                ", androidPwd='" + androidPwd + '\'' +
                '}';
    }
}
