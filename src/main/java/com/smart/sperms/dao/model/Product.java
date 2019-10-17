package com.smart.sperms.dao.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String proId;

    private String proName;

    private String proType;

    private String proSize;

    private String proMaterial;

    private Double proLength;

    private Double proWeightStd;

    private Double proWeightActual;

    private static final long serialVersionUID = 1L;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProSize() {
        return proSize;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }

    public String getProMaterial() {
        return proMaterial;
    }

    public void setProMaterial(String proMaterial) {
        this.proMaterial = proMaterial;
    }

    public Double getProLength() {
        return proLength;
    }

    public void setProLength(Double proLength) {
        this.proLength = proLength;
    }

    public Double getProWeightStd() {
        return proWeightStd;
    }

    public void setProWeightStd(Double proWeightStd) {
        this.proWeightStd = proWeightStd;
    }

    public Double getProWeightActual() {
        return proWeightActual;
    }

    public void setProWeightActual(Double proWeightActual) {
        this.proWeightActual = proWeightActual;
    }
}