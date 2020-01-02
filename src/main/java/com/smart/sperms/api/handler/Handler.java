package com.smart.sperms.api.handler;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.common.SpringContext;
import com.smart.sperms.config.mqtt.MqttConfig;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
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
        MqttConfig mqttConfig = SpringContext.getBean(MqttConfig.class);
        MqttSendService mqttService = SpringContext.getBean(MqttSendService.class);
        EquipmentDao equipmentDao = SpringContext.getBean(EquipmentDao.class);
        //TODO 改用redis
        Equipment equip = equipmentDao.queryByEid(eId);
        if(equip == null) {
            logger.error("equipment is not exists...eId = {}", eId);
            return;
        }

        String topic = mqttConfig.getTopic_smart_web() + eId;
        String key = equip.getAndroidPwd();
        String msg = JSON.toJSONString(msgPayload);
        String payload = XxteaUtils.encryptToHexString(msg, key);
        mqttService.sendToMqtt(topic, payload);

        logger.info("send msg to android...msg = {}", msg);
    }
}
