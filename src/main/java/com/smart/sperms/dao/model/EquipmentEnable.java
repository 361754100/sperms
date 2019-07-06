package com.smart.sperms.dao.model;

import java.io.Serializable;

public class EquipmentEnable implements Serializable {
    private String eId;

    private Integer eeEnable;

    private String eeCondition;

    private String eeLongitude;

    private String eeLatitude;

    private static final long serialVersionUID = 1L;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public Integer getEeEnable() {
        return eeEnable;
    }

    public void setEeEnable(Integer eeEnable) {
        this.eeEnable = eeEnable;
    }

    public String getEeCondition() {
        return eeCondition;
    }

    public void setEeCondition(String eeCondition) {
        this.eeCondition = eeCondition;
    }

    public String getEeLongitude() {
        return eeLongitude;
    }

    public void setEeLongitude(String eeLongitude) {
        this.eeLongitude = eeLongitude;
    }

    public String getEeLatitude() {
        return eeLatitude;
    }

    public void setEeLatitude(String eeLatitude) {
        this.eeLatitude = eeLatitude;
    }
}