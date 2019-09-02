package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑设备报废信息
 */
@ApiModel(description = "设备报废消息体")
public class ScrappEditReq implements Serializable {

    @ApiModelProperty(value = "设备ID")
    private String eId;

    @ApiModelProperty(value = "报废原因")
    private String scReason;

    @ApiModelProperty(value = "报废时间")
    private String scTime;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getScReason() {
        return scReason;
    }

    public void setScReason(String scReason) {
        this.scReason = scReason;
    }

    public String getScTime() {
        return scTime;
    }

    public void setScTime(String scTime) {
        this.scTime = scTime;
    }
}
