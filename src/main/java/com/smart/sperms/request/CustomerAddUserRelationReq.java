package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 客户关联系统用户
 */
@ApiModel(description = "客户关联系统用户消息体")
public class CustomerAddUserRelationReq implements Serializable {

    @ApiModelProperty(value = "客户编号")
    private String customerNo;

    @ApiModelProperty(value = "用户ID（多选）")
    private List<String> userIds;

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    @Override
    public String toString() {
        return "CustomerAddUserRelationReq{" +
                "customerNo=" + customerNo +
                ", userIds=" + userIds +
                '}';
    }
}
