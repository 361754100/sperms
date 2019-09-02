package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除仓库信息
 */
@ApiModel(description = "删除仓库信息")
public class StoreDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> storeIds;

    public List<String> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<String> storeIds) {
        this.storeIds = storeIds;
    }

    @Override
    public String toString() {
        return "StoreDelReq{" +
                "storeIds=" + storeIds +
                '}';
    }
}
