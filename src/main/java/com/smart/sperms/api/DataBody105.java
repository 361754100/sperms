package com.smart.sperms.api;

import java.io.Serializable;

/**
 * 105 消息体
 */
public class DataBody105 implements Serializable {

    // 经度
    private double longitude;

    // 纬度
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
