package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.Users;

/**
 * 用户信息DTO
 */
public class UsersDto extends Users {

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
