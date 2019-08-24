package com.smart.sperms.api.handler;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.api.protocol.DataBody101;
import com.smart.sperms.api.protocol.DataBody102;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.config.PropertiesConfig;
import com.smart.sperms.config.mqtt.MqttConfig;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.service.MqttSendService;
import com.smart.sperms.utils.XxteaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class Handler101 implements IHandler {

    private static Logger logger = LoggerFactory.getLogger(Handler101.class);

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private MqttSendService mqttService;

    @Autowired
    private PropertiesConfig propsConfig;

    @Autowired
    private MqttConfig mqttConfig;

    @Override
    public void execute(String eId, MsgPayload req) {
        DataBody101 reqBody = (DataBody101)req.getData();
        logger.info("recv android msg...reqBody = {}", reqBody);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_102.getCode());

        Equipment condition = new Equipment();
        condition.seteId(eId);
        List<Equipment> equipments = equipmentDao.queryList(condition);

        if(CollectionUtils.isEmpty(equipments)) {
            resp.setCode(ProtocolEnum.CODE_ERROR.getCode());
            return;
        }
        Equipment equipment = equipments.get(0);
        boolean work = false;
        if("true".equals(equipment.geteState())) {
            work = true;
        }
        DataBody102 respBody = new DataBody102();
        respBody.setWork(work);

        resp.setData(respBody);

        String topic = mqttConfig.getTopic_smart_web() + eId;
        String key = propsConfig.getXxtea_key_smart();
        String msg = JSON.toJSONString(resp);
        String payload = XxteaUtils.encryptToHexString(msg, key);
        mqttService.sendToMqtt(topic, payload);

        logger.info("send msg to android...resp = {}", msg);
    }
}
