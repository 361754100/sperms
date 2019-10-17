package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "产品类型消息体")
public class ProductEditReq implements Serializable {

    @ApiModelProperty(value = "产品类型ID")
    private String proId;

    @ApiModelProperty(value = "产品类型名称")
    private String proName;

    @ApiModelProperty(value = "产品型号")
    private String proType;

    @ApiModelProperty(value = "产品规格")
    private String proSize;

    @ApiModelProperty(value = "产品材质")
    private String proMaterial;

    @ApiModelProperty(value = "产品长度")
    private Double proLength;

    @ApiModelProperty(value = "产品理论重量")
    private Double proWeightStd;

    @ApiModelProperty(value = "产品实际重量")
    private Double proWeightActual;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProSize() {
        return proSize;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }

    public String getProMaterial() {
        return proMaterial;
    }

    public void setProMaterial(String proMaterial) {
        this.proMaterial = proMaterial;
    }

    public Double getProLength() {
        return proLength;
    }

    public void setProLength(Double proLength) {
        this.proLength = proLength;
    }

    public Double getProWeightStd() {
        return proWeightStd;
    }

    public void setProWeightStd(Double proWeightStd) {
        this.proWeightStd = proWeightStd;
    }

    public Double getProWeightActual() {
        return proWeightActual;
    }

    public void setProWeightActual(Double proWeightActual) {
        this.proWeightActual = proWeightActual;
    }

    @Override
    public String toString() {
        return "ProductEditReq{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", proType='" + proType + '\'' +
                ", proSize='" + proSize + '\'' +
                ", proMaterial='" + proMaterial + '\'' +
                ", proLength=" + proLength +
                ", proWeightStd=" + proWeightStd +
                ", proWeightActual=" + proWeightActual +
                '}';
    }
}