package com.smart.sperms.api.protocol;

import java.io.Serializable;

/**
 * 113 消息体
 */
public class DataBody113 implements Serializable {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataBody113{" +
                "password='" + password + '\'' +
                '}';
    }
}
