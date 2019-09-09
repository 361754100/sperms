package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑自动停/锁机策略
 */
@ApiModel(description = "自动停/锁机策略")
public class LockRuleEditReq implements Serializable {

    @ApiModelProperty(value = "锁机策略")
    private String lrNo;

    @ApiModelProperty(value = "锁机名称")
    private String lrName;

    @ApiModelProperty(value = "按天或按量,1=按量；2=按天；3=其它")
    private Integer lrType;

    @ApiModelProperty(value = "锁机天数")
    private Integer lrUnit;

    @ApiModelProperty(value = "锁机金额（设备生产的产值达到一定额度后，自动锁机用字段）")
    private Double lrTotal;

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

    @Override
    public String toString() {
        return "LockRuleEditReq{" +
                "lrNo='" + lrNo + '\'' +
                ", lrName='" + lrName + '\'' +
                ", lrType=" + lrType +
                ", lrUnit=" + lrUnit +
                ", lrTotal=" + lrTotal +
                '}';
    }
}
