package com.smart.sperms.api.protocol;

import java.io.Serializable;

/**
 * 116 消息体
 */
public class DataBody116 implements Serializable {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataBody116{" +
                "password='" + password + '\'' +
                '}';
    }
}
