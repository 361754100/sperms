package com.smart.sperms.api.handler;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.api.protocol.DataBody116;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.common.SpringContext;
import com.smart.sperms.config.mqtt.MqttConfig;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.service.MqttSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 处理115协议
 */
@Component
public class Handler115 extends Handler {

    @Autowired
    private EquipmentDao equipmentDao;

    @Override
    public void execute(String eId, MsgPayload req) {
        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_116.getCode());

        DataBody116 data = new DataBody116();

        Equipment condition = new Equipment();
        condition.seteId(eId);
        List<Equipment> equips = equipmentDao.queryList(condition);
        if(!CollectionUtils.isEmpty(equips)) {
            Equipment tmpEquip = equips.get(0);
            data.setPassword(tmpEquip.getAndroidPwd());
        }

        resp.setData(data);
//        super.sendMsg(eId, resp);

        MqttConfig mqttConfig = SpringContext.getBean(MqttConfig.class);
        MqttSendService mqttService = SpringContext.getBean(MqttSendService.class);

        String topic = mqttConfig.getTopic_smart_web() + eId;
        String payload = JSON.toJSONString(resp);
        logger.info("send msg to android...msg = {}", payload);
        mqttService.sendToMqtt(topic, payload);
    }

}
