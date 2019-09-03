package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.enums.ProtocolEnum;
import org.springframework.stereotype.Component;

/**
 * 处理10001协议
 */
@Component
public class Handler10001 extends Handler {

    @Override
    public void execute(String eId, MsgPayload req) {
        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_10002.getCode());

        super.sendMsg(eId, resp);
    }

}
