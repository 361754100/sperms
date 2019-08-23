package com.smart.sperms.api;

import java.io.Serializable;

/**
 * 通用消息体
 */
public class CommonPayload implements Serializable {

    private int protocol;
    private int code;
    private Object data;

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
