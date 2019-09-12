package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑计费方式
 */
@ApiModel(description = "编辑计费方式消息体")
public class CaculationMethodEditReq implements Serializable {

    @ApiModelProperty(value = "计费编号")
    private String cmNo;

    @ApiModelProperty(value = "计费名称")
    private String cmName;

    @ApiModelProperty(value = "按天或按量,1=按量; 2=按天; 3=其它")
    private Integer cmType;

    @ApiModelProperty(value = "计量单位")
    private Integer cmUnit;

    @ApiModelProperty(value = "单价")
    private Double cmPrice;

    @ApiModelProperty(value = "保留")
    private Integer cmRemain;

    public String getCmNo() {
        return cmNo;
    }

    public void setCmNo(String cmNo) {
        this.cmNo = cmNo;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public Integer getCmType() {
        return cmType;
    }

    public void setCmType(Integer cmType) {
        this.cmType = cmType;
    }

    public Integer getCmUnit() {
        return cmUnit;
    }

    public void setCmUnit(Integer cmUnit) {
        this.cmUnit = cmUnit;
    }

    public Double getCmPrice() {
        return cmPrice;
    }

    public void setCmPrice(Double cmPrice) {
        this.cmPrice = cmPrice;
    }

    public Integer getCmRemain() {
        return cmRemain;
    }

    public void setCmRemain(Integer cmRemain) {
        this.cmRemain = cmRemain;
    }

    @Override
    public String toString() {
        return "CaculationMethodEditReq{" +
                "cmNo='" + cmNo + '\'' +
                ", cmName='" + cmName + '\'' +
                ", cmType=" + cmType +
                ", cmUnit=" + cmUnit +
                ", cmPrice=" + cmPrice +
                ", cmRemain=" + cmRemain +
                '}';
    }
}
