package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.DataBody105;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.enums.ProtocolEnum;
import org.springframework.stereotype.Component;

/**
 * 处理105协议
 */
@Component
public class Handler105 extends Handler {

    @Override
    public void execute(String eId, MsgPayload req) {
        DataBody105 reqBody = (DataBody105)req.getData();
        logger.info("recv android msg...body = {}", reqBody);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_106.getCode());

        super.sendMsg(eId, resp);
    }

}
