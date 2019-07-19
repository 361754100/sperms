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

    @ApiModelProperty(value = "按天或按量")
    private Integer cmDay;

    @ApiModelProperty(value = "费用")
    private Double cmFee;

    @ApiModelProperty(value = "保留")
    private Integer cmRemain;

    public String getCmNo() {
        return cmNo;
    }

    public void setCmNo(String cmNo) {
        this.cmNo = cmNo;
    }

    public Integer getCmDay() {
        return cmDay;
    }

    public void setCmDay(Integer cmDay) {
        this.cmDay = cmDay;
    }

    public Double getCmFee() {
        return cmFee;
    }

    public void setCmFee(Double cmFee) {
        this.cmFee = cmFee;
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
                ", cmDay=" + cmDay +
                ", cmFee=" + cmFee +
                ", cmRemain=" + cmRemain +
                '}';
    }
}
