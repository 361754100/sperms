package com.smart.sperms.api.protocol;

import java.io.Serializable;

/**
 * 101 消息体
 */
public class DataBody101 implements Serializable {

    private String firmwareVersion;
    private String softwareVersion;

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    @Override
    public String toString() {
        return "DataBody101{" +
                "firmwareVersion='" + firmwareVersion + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                '}';
    }
}
