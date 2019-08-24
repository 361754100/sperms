package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.MsgPayload;

public interface IHandler {

    /**
     * 消息处理
     * @param eId   设备ID
     * @param req   消息体
     */
    public void execute(String eId, MsgPayload req);
}
