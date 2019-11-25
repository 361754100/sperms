package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除设备维修信息
 */
@ApiModel(description = "删除设备维修消息体")
public class RepairDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<Integer> rIds;

    public List<Integer> getrIds() {
        return rIds;
    }

    public void setrIds(List<Integer> rIds) {
        this.rIds = rIds;
    }

    @Override
    public String toString() {
        return "RepairDelReq{" +
                "rIds=" + rIds +
                '}';
    }
}
