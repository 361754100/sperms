package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.Scrapp;

/**
 * 设备报废DTO
 */
public class ScrappDto extends Scrapp {

    private String eName;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return "ScrappDto{" +
                "eName='" + eName + '\'' +
                '}';
    }
}
