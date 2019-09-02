package com.smart.sperms.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Scrapp implements Serializable {
    private String eId;

    private Date scTime;

    private String scReason;

    private static final long serialVersionUID = 1L;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public Date getScTime() {
        return scTime;
    }

    public void setScTime(Date scTime) {
        this.scTime = scTime;
    }

    public String getScReason() {
        return scReason;
    }

    public void setScReason(String scReason) {
        this.scReason = scReason;
    }
}