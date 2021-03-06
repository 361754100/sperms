package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑菜单信息
 */
@ApiModel(description = "菜单信息消息体")
public class SysMenuAddReq implements Serializable {

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单状态（0:停用 1:启用）")
    private Integer menuStatus;

    @ApiModelProperty(value = "菜单连接")
    private String menuUrl;

    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;

    @ApiModelProperty(value = "父节点ID")
    private Integer parentId;

    @ApiModelProperty(value = "菜单备注")
    private String menuRemark;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
        this.menuStatus = menuStatus;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark;
    }

    @Override
    public String toString() {
        return "SysMenuAddReq{" +
                "menuName='" + menuName + '\'' +
                ", menuStatus=" + menuStatus +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", parentId=" + parentId +
                ", menuRemark='" + menuRemark + '\'' +
                '}';
    }
}
