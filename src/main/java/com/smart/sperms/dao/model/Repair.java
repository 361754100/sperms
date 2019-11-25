package com.smart.sperms.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Repair implements Serializable {
    private Integer id;

    private String eId;

    private Date rTime;

    private String rManufacturer;

    private String errCode;

    private String rState;

    private Double rCost;

    private String rPerson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public String getrManufacturer() {
        return rManufacturer;
    }

    public void setrManufacturer(String rManufacturer) {
        this.rManufacturer = rManufacturer;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getrState() {
        return rState;
    }

    public void setrState(String rState) {
        this.rState = rState;
    }

    public Double getrCost() {
        return rCost;
    }

    public void setrCost(Double rCost) {
        this.rCost = rCost;
    }

    public String getrPerson() {
        return rPerson;
    }

    public void setrPerson(String rPerson) {
        this.rPerson = rPerson;
    }
}