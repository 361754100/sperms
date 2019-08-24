package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.MsgPayload;
import org.springframework.stereotype.Component;

/**
 * 处理108协议
 */
@Component
public class Handler108 extends Handler {

    @Override
    public void execute(String eId, MsgPayload req) {
        logger.info("recv android msg...body = {}", req);
        //TODO...
    }

}
