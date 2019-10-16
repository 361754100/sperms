package com.smart.sperms.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Equipment implements Serializable {
    private String eId;

    private String eName;

    private String eStandard;

    private String eManufacturer;

    private String eType;

    private Date eDate;

    private String eState;

    private Integer eEnable;

    private String eLongitude;

    private String eLatitude;

    private String eCondition;

    private static final long serialVersionUID = 1L;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteStandard() {
        return eStandard;
    }

    public void seteStandard(String eStandard) {
        this.eStandard = eStandard;
    }

    public String geteManufacturer() {
        return eManufacturer;
    }

    public void seteManufacturer(String eManufacturer) {
        this.eManufacturer = eManufacturer;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public String geteState() {
        return eState;
    }

    public void seteState(String eState) {
        this.eState = eState;
    }

    public Integer geteEnable() {
        return eEnable;
    }

    public void seteEnable(Integer eEnable) {
        this.eEnable = eEnable;
    }

    public String geteLongitude() {
        return eLongitude;
    }

    public void seteLongitude(String eLongitude) {
        this.eLongitude = eLongitude;
    }

    public String geteLatitude() {
        return eLatitude;
    }

    public void seteLatitude(String eLatitude) {
        this.eLatitude = eLatitude;
    }

    public String geteCondition() {
        return eCondition;
    }

    public void seteCondition(String eCondition) {
        this.eCondition = eCondition;
    }
}