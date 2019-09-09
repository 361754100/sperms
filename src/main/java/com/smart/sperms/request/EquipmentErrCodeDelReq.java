package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除故障信息
 */
@ApiModel(description = "删除故障信息")
public class EquipmentErrCodeDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> errCodes;

    public List<String> getErrCodes() {
        return errCodes;
    }

    public void setErrCodes(List<String> errCodes) {
        this.errCodes = errCodes;
    }

    @Override
    public String toString() {
        return "EquipmentErrCodeDelReq{" +
                "errCodes=" + errCodes +
                '}';
    }
}
