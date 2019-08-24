package com.smart.sperms.api.protocol;

import java.io.Serializable;

/**
 * 109 消息体
 */
public class DataBody109 implements Serializable {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DataBody109{" +
                "address='" + address + '\'' +
                '}';
    }
}
