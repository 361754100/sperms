package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.SysMenu;

public class SysMenuDto extends SysMenu {

    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysMenuDto{" +
                "roleId=" + roleId +
                '}';
    }
}
