package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除计费方式
 */
@ApiModel(description = "删除计费方式消息体")
public class CaculationMethodDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> cmNos;

    public List<String> getCmNos() {
        return cmNos;
    }

    public void setCmNos(List<String> cmNos) {
        this.cmNos = cmNos;
    }

    @Override
    public String toString() {
        return "CaculationMethodDelReq{" +
                "cmNos=" + cmNos +
                '}';
    }
}
