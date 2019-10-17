package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除产品类型
 */
@ApiModel(description = "删除产品类型消息体")
public class ProductDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> proIds;

    public List<String> getProIds() {
        return proIds;
    }

    public void setProIds(List<String> proIds) {
        this.proIds = proIds;
    }

    @Override
    public String toString() {
        return "ProductDelReq{" +
                "proIds=" + proIds +
                '}';
    }
}
