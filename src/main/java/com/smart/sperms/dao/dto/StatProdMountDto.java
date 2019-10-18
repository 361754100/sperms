package com.smart.sperms.dao.dto;

import java.io.Serializable;

/**
 * 产量统计Dto
 */
public class StatProdMountDto implements Serializable {

    private String dataTime;

    private Double psMount;

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
        return "StatProdMountDto{" +
                "dataTime='" + dataTime + '\'' +
                ", psMount=" + psMount +
                '}';
    }
}
