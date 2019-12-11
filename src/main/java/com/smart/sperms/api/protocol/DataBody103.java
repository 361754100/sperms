package com.smart.sperms.api.protocol;

import java.io.Serializable;

/**
 * 103 消息体
 */
public class DataBody103 implements Serializable {

    private int type;

    private int count;

    private String startTime;

    private String endTime;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DataBody103{" +
                "type=" + type +
                ", count=" + count +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
