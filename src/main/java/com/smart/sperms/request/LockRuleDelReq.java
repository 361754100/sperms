package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除策略信息
 */
@ApiModel(description = "删除策略信息")
public class LockRuleDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> lrNos;

    public List<String> getLrNos() {
        return lrNos;
    }

    public void setLrNos(List<String> lrNos) {
        this.lrNos = lrNos;
    }

    @Override
    public String toString() {
        return "LockRuleDelReq{" +
                "lrNos=" + lrNos +
                '}';
    }
}
