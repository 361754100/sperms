package com.smart.sperms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑车辆信息
 */
@ApiModel(description = "车辆信息消息体")
public class CarInfoQueryReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private int recordId;

    @ApiModelProperty(value = "车辆名称")
    private String carName;

    @ApiModelProperty(value = "车牌号码")
    private String carNo;

    @ApiModelProperty(value = "车辆颜色")
    private String carColor;

    @ApiModelProperty(value = "车主ID")
    private int ownerId;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Override
    public String toString() {
        return "EditCarInfoReq{" +
                "recordId=" + recordId +
                ", carName='" + carName + '\'' +
                ", carNo='" + carNo + '\'' +
                ", carColor='" + carColor + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
