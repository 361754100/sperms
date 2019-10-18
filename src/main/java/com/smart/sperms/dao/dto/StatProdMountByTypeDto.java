package com.smart.sperms.dao.dto;

import java.io.Serializable;

/**
 * 产品类型产量统计Dto
 *
 */
public class StatProdMountByTypeDto implements Serializable {

    private String proId;

    private String proName;

    private String dataTime;

    private Double psMount;

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

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public Double getPsMount() {
        return psMount;
    }

    public void setPsMount(Double psMount) {
        this.psMount = psMount;
    }

    @Override
    public String toString() {
        return "StatProdMountByDayDto{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", dataTime='" + dataTime + '\'' +
                ", psMount=" + psMount +
                '}';
    }
}
