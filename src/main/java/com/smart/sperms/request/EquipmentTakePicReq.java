package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 设备拍照
 */
@ApiModel(description = "设备拍照消息体")
public class EquipmentTakePicReq implements Serializable {

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
        return "EquipmentTakePicReq{" +
                "eIds=" + eIds +
                '}';
    }
}
