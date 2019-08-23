package com.smart.sperms.api;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.common.SpringContext;
import com.smart.sperms.config.PropertiesConfig;
import com.smart.sperms.config.mqtt.MqttConfig;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.utils.XxteaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 协议消息解析器
 */
public class ProtocolFactory {

    private static Logger logger = LoggerFactory.getLogger(ProtocolFactory.class);

    public static void decode(String topic, String data) {
        MqttConfig mqttConfig = SpringContext.getBean(MqttConfig.class);
        PropertiesConfig propConfig = SpringContext.getBean(PropertiesConfig.class);
        String equipmentId = topic.replace(mqttConfig.getTopic_smart_android(), "");

        // 排除104消息，不需要解密
        if(data.contains("\"protocol\":104")) {
            //TODO...
        }
        String msgBody = XxteaUtils.decryptFromHexString(data, propConfig.getXxtea_key_smart());
        CommonPayload payload = JSON.parseObject(msgBody, CommonPayload.class);

        ProtocolEnum protocol = ProtocolEnum.getProtocol(payload.getProtocol());
        switch(protocol) {
            case CODE_101:
                break;
            case CODE_102:
                break;
            case CODE_103:
                break;
            case CODE_104:
                break;
            case CODE_105:
                break;
            case CODE_106:
                break;
            case CODE_107:
                break;
            case CODE_108:
                break;
            case CODE_109:
                break;
            case CODE_110:
                break;
            case CODE_111:
                break;
            case CODE_112:
                break;
            case CODE_113:
                break;
            case CODE_114:
                break;
            default:
                break;
        }
        logger.info("equipmentId = {}", equipmentId);
    }
}
