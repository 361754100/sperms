package com.smart.sperms.api.protocol;

import com.smart.sperms.enums.ProtocolEnum;

import java.io.Serializable;

/**
 * 通用消息体
 */
public class MsgPayload implements Serializable {

    private int protocol;
    private int code = ProtocolEnum.CODE_SUCCESS.getCode();
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

    @Override
    public String toString() {
        return "MsgPayload{" +
                "protocol=" + protocol +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
