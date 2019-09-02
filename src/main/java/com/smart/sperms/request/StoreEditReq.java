package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑仓库信息
 */
@ApiModel(description = "仓库信息消息体")
public class StoreEditReq implements Serializable {

    @ApiModelProperty(value = "仓库ID")
    private String storeId;

    @ApiModelProperty(value = "仓库名称")
    private String storeName;

    @ApiModelProperty(value = "所在区域")
    private String storePlace;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePlace() {
        return storePlace;
    }

    public void setStorePlace(String storePlace) {
        this.storePlace = storePlace;
    }

    @Override
    public String toString() {
        return "StoreEditReq{" +
                "storeId='" + storeId + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storePlace='" + storePlace + '\'' +
                '}';
    }
}
