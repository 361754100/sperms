package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 设备应用信息
 */
@ApiModel(description = "设备应用信息消息体")
public class ProductionStatEditReq implements Serializable {

    @ApiModelProperty(value = "设备ID")
    private String eId;

    @ApiModelProperty(value = "开始日期")
    private String psDate;

    @ApiModelProperty(value = "结束日期")
    private String psEndDate;

    @ApiModelProperty(value = "产量")
    private Integer psMount;

    @ApiModelProperty(value = "产品类型ID")
    private String proId;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getPsDate() {
        return psDate;
    }

    public void setPsDate(String psDate) {
        this.psDate = psDate;
    }

    public String getPsEndDate() {
        return psEndDate;
    }

    public void setPsEndDate(String psEndDate) {
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

    @Override
    public String toString() {
        return "ProductionStatEditReq{" +
                "eId='" + eId + '\'' +
                ", psDate='" + psDate + '\'' +
                ", psEndDate='" + psEndDate + '\'' +
                ", psMount=" + psMount +
                ", proId='" + proId + '\'' +
                '}';
    }
}
