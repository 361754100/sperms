package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除角色关联菜单信息
 */
@ApiModel(description = "删除角色关联菜单消息体")
public class SysRoleDelMenuRelationReq implements Serializable {

    @ApiModelProperty(value = "角色ID")
    private int roleId;

    @ApiModelProperty(value = "菜单ID（多选）")
    private List<Integer> menuIds;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "SysRoleDelMenuRelationReq{" +
                "roleId=" + roleId +
                ", menuIds=" + menuIds +
                '}';
    }
}
