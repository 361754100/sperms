package com.smart.sperms.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ProductionStat implements Serializable {
    private Integer id;

    private String eId;

    private Date psDate;

    private Date psEndDate;

    private Integer psMount;

    private String proId;

    private Integer psQuantity;

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

    public Date getPsDate() {
        return psDate;
    }

    public void setPsDate(Date psDate) {
        this.psDate = psDate;
    }

    public Date getPsEndDate() {
        return psEndDate;
    }

    public void setPsEndDate(Date psEndDate) {
        this.psEndDate = psEndDate;
    }

    public Integer getPsMount() {
        return psMount;
    }

    public void setPsMount(Integer psMount) {
        this.psMount = psMount;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public Integer getPsQuantity() {
        return psQuantity;
    }

    public void setPsQuantity(Integer psQuantity) {
        this.psQuantity = psQuantity;
    }
}