package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.ProductionStat;

/**
 * 生产统计表Dto
 */
public class ProductionStatDto extends ProductionStat {

    private String eName;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return "ProductionStatDto{" +
                "eName='" + eName + '\'' +
                '}';
    }
}
