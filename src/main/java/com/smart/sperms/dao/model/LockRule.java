package com.smart.sperms.dao.model;

import java.io.Serializable;

public class LockRule implements Serializable {
    private String lrNo;

    private String lrName;

    private Integer lrType;

    private Integer lrUnit;

    private Double lrTotal;

    private static final long serialVersionUID = 1L;

    public String getLrNo() {
        return lrNo;
    }

    public void setLrNo(String lrNo) {
        this.lrNo = lrNo;
    }

    public String getLrName() {
        return lrName;
    }

    public void setLrName(String lrName) {
        this.lrName = lrName;
    }

    public Integer getLrType() {
        return lrType;
    }

    public void setLrType(Integer lrType) {
        this.lrType = lrType;
    }

    public Integer getLrUnit() {
        return lrUnit;
    }

    public void setLrUnit(Integer lrUnit) {
        this.lrUnit = lrUnit;
    }

    public Double getLrTotal() {
        return lrTotal;
    }

    public void setLrTotal(Double lrTotal) {
        this.lrTotal = lrTotal;
    }
}