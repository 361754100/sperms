package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除菜单信息
 */
@ApiModel(description = "删除菜单信息消息体")
public class SysMenuDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<Integer> menuIds;

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "SysMenuDelReq{" +
                "menuIds=" + menuIds +
                '}';
    }
}
