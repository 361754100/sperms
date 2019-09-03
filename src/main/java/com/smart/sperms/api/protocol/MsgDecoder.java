package com.smart.sperms.api.protocol;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.api.handler.*;
import com.smart.sperms.common.SpringContext;
import com.smart.sperms.config.PropertiesConfig;
import com.smart.sperms.config.mqtt.MqttConfig;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.utils.XxteaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * 协议消息解析器
 */
public class MsgDecoder {

    private static Logger logger = LoggerFactory.getLogger(MsgDecoder.class);

    public static void decode(String topic, String data) {
        MqttConfig mqttConfig = SpringContext.getBean(MqttConfig.class);
        PropertiesConfig propConfig = SpringContext.getBean(PropertiesConfig.class);
        String equipmentId = topic.replace(mqttConfig.getTopic_smart_android(), "");

        Handler handler = null;
        // 排除114消息，不需要解密
        if(data.contains("\"protocol\":114")) {
            handler = SpringContext.getBean(Handler114.class);
            MsgPayload payload114 = parseObject(data, MsgPayload.class);

            logger.info("equipmentId = {}, protocol = {}", equipmentId, payload114);
            handler.execute(equipmentId, payload114);
            return;
        }
        String msgBody = XxteaUtils.decryptFromHexString(data, propConfig.getXxtea_key_smart());
        MsgPayload payload = JSON.parseObject(msgBody, MsgPayload.class);
        String dataStr = String.valueOf(payload.getData());
        Object dataBody = null;

        ProtocolEnum protocol = ProtocolEnum.getProtocol(payload.getProtocol());
        switch(protocol) {
            case CODE_10001:
                handler = SpringContext.getBean(Handler10001.class);
                break;
            case CODE_10002:
                break;
            case CODE_101:
                handler = SpringContext.getBean(Handler101.class);
                dataBody = JSON.parseObject(dataStr, DataBody101.class);
                break;
            case CODE_102:
                break;
            case CODE_103:
                handler = SpringContext.getBean(Handler103.class);
                dataBody = JSON.parseObject(dataStr, DataBody103.class);
                break;
            case CODE_104:
                break;
            case CODE_105:
                handler = SpringContext.getBean(Handler105.class);
                dataBody = JSON.parseObject(dataStr, DataBody105.class);
                break;
            case CODE_106:
                break;
            case CODE_107:
                handler = SpringContext.getBean(Handler107.class);
                dataBody = JSON.parseObject(dataStr, DataBody107.class);
                break;
            case CODE_108:
                break;
            case CODE_109:
                handler = SpringContext.getBean(Handler109.class);
                dataBody = JSON.parseObject(dataStr, DataBody109.class);
                break;
            case CODE_110:
                handler = SpringContext.getBean(Handler110.class);
                break;
            case CODE_111:
                break;
            case CODE_112:
                handler = SpringContext.getBean(Handler112.class);
                dataBody = JSON.parseObject(dataStr, DataBody112.class);
                break;
            case CODE_113:
                break;
//            case CODE_114:
//                handler = SpringContext.getBean(Handler114.class);
//                break;
            case CODE_114:
                break;
            case CODE_SUCCESS:
                break;
            case CODE_ERROR:
                break;
            default:
                break;
        }

        logger.info("equipmentId = {}, protocol = {}", equipmentId, payload.getProtocol());
        if(handler != null) {
            payload.setData(dataBody);
            handler.execute(equipmentId, payload);
        }
    }
}
