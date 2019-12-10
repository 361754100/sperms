package com.smart.sperms.api.protocol;

import java.io.Serializable;

/**
 * 109 消息体
 */
public class DataBody109 implements Serializable {

    private short address;

    private int slaveAddress;

    private int type;

    public short getAddress() {
        return address;
    }

    public void setAddress(short address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSlaveAddress() {
        return slaveAddress;
    }

    public void setSlaveAddress(int slaveAddress) {
        this.slaveAddress = slaveAddress;
    }

    @Override
    public String toString() {
        return "DataBody109{" +
                "address=" + address +
                ", slaveAddress=" + slaveAddress +
                ", type=" + type +
                '}';
    }
}
