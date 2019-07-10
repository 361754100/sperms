package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除租赁信息
 */
@ApiModel(description = "删除租赁信息消息体")
public class RentManagerDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> tradeNos;

    public List<String> getTradeNos() {
        return tradeNos;
    }

    public void setTradeNos(List<String> tradeNos) {
        this.tradeNos = tradeNos;
    }
}
