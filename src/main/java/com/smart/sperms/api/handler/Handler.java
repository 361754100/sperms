package com.smart.sperms.api.handler;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.common.SpringContext;
import com.smart.sperms.config.PropertiesConfig;
import com.smart.sperms.config.mqtt.MqttConfig;
import com.smart.sperms.service.MqttSendService;
import com.smart.sperms.utils.XxteaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Handler {

    static Logger logger = LoggerFactory.getLogger(Handler.class);

    /**
     * 消息处理
     * @param eId   设备ID
     * @param req   消息体
     */
    public abstract void execute(String eId, MsgPayload req);

    public void sendMsg(String eId, MsgPayload msgPayload) {
        PropertiesConfig propsConfig = SpringContext.getBean(PropertiesConfig.class);
        MqttConfig mqttConfig = SpringContext.getBean(MqttConfig.class);
        MqttSendService mqttService = SpringContext.getBean(MqttSendService.class);

        String topic = mqttConfig.getTopic_smart_web() + eId;
        String key = propsConfig.getXxtea_key_smart();
        String msg = JSON.toJSONString(msgPayload);
        String payload = XxteaUtils.encryptToHexString(msg, key);
        mqttService.sendToMqtt(topic, payload);

        logger.info("send msg to android...msg = {}", msg);
    }
}
