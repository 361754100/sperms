package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.ProductionStat;

/**
 * 生产统计表Dto
 */
public class ProductionStatDto extends ProductionStat {

    private String eName;

    private String proName;

    private String proType;

    private String proSize;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
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

    @Override
    public String toString() {
        return "ProductionStatDto{" +
                "eName='" + eName + '\'' +
                ", proName='" + proName + '\'' +
                ", proType='" + proType + '\'' +
                ", proSize='" + proSize + '\'' +
                '}';
    }
}
