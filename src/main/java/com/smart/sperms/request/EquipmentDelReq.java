package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除设备信息
 */
@ApiModel(description = "删除设备信息消息体")
public class EquipmentDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> eIds;

    public List<String> geteIds() {
        return eIds;
    }

    public void seteIds(List<String> eIds) {
        this.eIds = eIds;
    }

    @Override
    public String toString() {
        return "EquipmentDelReq{" +
                "eIds=" + eIds +
                '}';
    }
}
