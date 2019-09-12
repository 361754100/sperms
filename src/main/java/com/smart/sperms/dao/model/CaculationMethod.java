package com.smart.sperms.dao.model;

import java.io.Serializable;

public class CaculationMethod implements Serializable {
    private String cmNo;

    private String cmName;

    private Integer cmType;

    private Integer cmUnit;

    private Double cmPrice;

    private Integer cmRemain;

    private static final long serialVersionUID = 1L;

    public String getCmNo() {
        return cmNo;
    }

    public void setCmNo(String cmNo) {
        this.cmNo = cmNo;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public Integer getCmType() {
        return cmType;
    }

    public void setCmType(Integer cmType) {
        this.cmType = cmType;
    }

    public Integer getCmUnit() {
        return cmUnit;
    }

    public void setCmUnit(Integer cmUnit) {
        this.cmUnit = cmUnit;
    }

    public Double getCmPrice() {
        return cmPrice;
    }

    public void setCmPrice(Double cmPrice) {
        this.cmPrice = cmPrice;
    }

    public Integer getCmRemain() {
        return cmRemain;
    }

    public void setCmRemain(Integer cmRemain) {
        this.cmRemain = cmRemain;
    }
}