package com.smart.sperms.api.protocol;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.api.handler.*;
import com.smart.sperms.common.SpringContext;
import com.smart.sperms.config.mqtt.MqttConfig;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.utils.XxteaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * 协议消息解析器
 */
public class MsgDecoder {

    private static Logger logger = LoggerFactory.getLogger(MsgDecoder.class);

    private static Map<String, Equipment> redisEquipMap = new HashMap<>();

    public static void decode(String topic, String data) {
        MqttConfig mqttConfig = SpringContext.getBean(MqttConfig.class);
        EquipmentDao equipmentDao = SpringContext.getBean(EquipmentDao.class);
        String equipmentId = topic.replace(mqttConfig.getTopic_smart_android(), "");

        Equipment equip = redisEquipMap.get(equipmentId);
        if(equip == null) {
            equip = equipmentDao.queryByEid(equipmentId);
            if(equip == null) {
                logger.error("equipment is not exists...eId = {}", equipmentId);
                return;
            }
            //TODO 放入redis
//            redisEquipMap.put(equipmentId, equip);
        }

        Handler handler = null;
        // 排除114消息，不需要解密
        if(data.contains("\"protocol\":114")) {
            handler = SpringContext.getBean(Handler114.class);
            MsgPayload payload114 = parseObject(data, MsgPayload.class);

            logger.info("equipmentId = {}, protocol = {}", equipmentId, payload114);
            handler.execute(equipmentId, payload114);
            return;
        }
        // 排除 115消息，不需要解密
        else if(data.contains("\"protocol\":115")) {
            handler = SpringContext.getBean(Handler115.class);
            MsgPayload payload115 = parseObject(data, MsgPayload.class);

            logger.info("equipmentId = {}, protocol = {}", equipmentId, payload115);
            handler.execute(equipmentId, payload115);
            return;
        }
        String msgBody = XxteaUtils.decryptFromHexString(data, equip.getAndroidPwd());
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
                dataBody = JSON.parseArray(dataStr, DataBody103.class);
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
//            case CODE_115:
//                handler = SpringContext.getBean(Handler115.class);
//                break;
            case CODE_116:
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
