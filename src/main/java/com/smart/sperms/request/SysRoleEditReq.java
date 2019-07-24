package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑角色信息
 */
@ApiModel(description = "角色信息消息体")
public class SysRoleEditReq implements Serializable {

    @ApiModelProperty(value = "角色ID")
    private Integer roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色状态（0:停用 1:启用）")
    private Integer roleStatus;

    @ApiModelProperty(value = "角色备注")
    private String roleRemark;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    @Override
    public String toString() {
        return "SysRoleEditReq{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleStatus=" + roleStatus +
                ", roleRemark='" + roleRemark + '\'' +
                '}';
    }
}
