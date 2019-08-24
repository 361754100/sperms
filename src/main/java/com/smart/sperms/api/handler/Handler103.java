package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.DataBody103;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.enums.ProtocolEnum;
import org.springframework.stereotype.Component;

/**
 * 处理103协议
 */
@Component
public class Handler103 extends Handler {

    @Override
    public void execute(String eId, MsgPayload req) {
        DataBody103 reqBody = (DataBody103)req.getData();
        logger.info("recv android msg...body = {}", reqBody);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_104.getCode());

        super.sendMsg(eId, resp);
    }

}
