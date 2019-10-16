package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 设备授权信息
 */
@ApiModel(description = "设备启停消息体")
public class EquipmentEnableEditReq implements Serializable {

    @ApiModelProperty(value = "设备ID")
    private List<String> eIds;

    @ApiModelProperty(value = "应用授权（0：关停；1：开启）")
    private Integer eEnable;

    public List<String> geteIds() {
        return eIds;
    }

    public void seteIds(List<String> eIds) {
        this.eIds = eIds;
    }

    public Integer geteEnable() {
        return eEnable;
    }

    public void seteEnable(Integer eEnable) {
        this.eEnable = eEnable;
    }

    @Override
    public String toString() {
        return "EquipmentEnableEditReq{" +
                "eIds=" + eIds +
                ", eEnable=" + eEnable +
                '}';
    }
}
