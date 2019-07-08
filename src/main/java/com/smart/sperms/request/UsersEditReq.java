package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑用户信息
 */
@ApiModel(description = "用户信息消息体")
public class UsersEditReq implements Serializable {

    @ApiModelProperty(value = "用户账号")
    private String uId;

    @ApiModelProperty(value = "用户名称")
    private String uName;

    @ApiModelProperty(value = "用户密码")
    private String uPassword;

    @ApiModelProperty(value = "角色ID")
    private Integer roleId;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UsersEditReq{" +
                "uId='" + uId + '\'' +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
