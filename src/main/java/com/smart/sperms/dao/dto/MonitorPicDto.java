package com.smart.sperms.dao.dto;

import com.smart.sperms.dao.model.MonitorPic;

/**
 * 设备图像Dto
 */
public class MonitorPicDto extends MonitorPic {

    private String eName;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return "MonitorPicDto{" +
                "eName='" + eName + '\'' +
                '}';
    }
}
