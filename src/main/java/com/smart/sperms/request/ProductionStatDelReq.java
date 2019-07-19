package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除生产统计信息
 */
@ApiModel(description = "删除生产统计信息消息体")
public class ProductionStatDelReq implements Serializable {

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
        return "ProductionStatDelReq{" +
                "eIds=" + eIds +
                '}';
    }
}
