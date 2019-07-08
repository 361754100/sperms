package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除用户信息
 */
@ApiModel(description = "删除用户信息消息体")
public class UsersDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<String> uIds;

    public List<String> getuIds() {
        return uIds;
    }

    public void setuIds(List<String> uIds) {
        this.uIds = uIds;
    }

    @Override
    public String toString() {
        return "UsersDelReq{" +
                "uIds=" + uIds +
                '}';
    }
}
