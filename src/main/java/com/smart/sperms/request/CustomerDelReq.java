package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除客户信息
 */
@ApiModel(description = "删除客户信息消息体")
public class CustomerDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> customerNos;

    public List<String> getCustomerNos() {
        return customerNos;
    }

    public void setCustomerNos(List<String> customerNos) {
        this.customerNos = customerNos;
    }

    @Override
    public String toString() {
        return "CustomerDelReq{" +
                "customerNos=" + customerNos +
                '}';
    }
}
