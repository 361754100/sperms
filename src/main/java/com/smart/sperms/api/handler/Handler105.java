package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.DataBody105;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.enums.ProtocolEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 处理105协议
 */
@Component
public class Handler105 extends Handler {

    @Autowired
    private EquipmentDao equipmentDao;

    @Override
    public void execute(String eId, MsgPayload req) {
        DataBody105 reqBody = (DataBody105)req.getData();
        logger.info("recv android msg...body = {}", reqBody);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_106.getCode());

        super.sendMsg(eId, resp);

        Equipment condition = new Equipment();
        condition.seteId(eId);

        List<Equipment> equips = equipmentDao.queryList(condition);
        if(CollectionUtils.isEmpty(equips)) {
            logger.error("equipment enable is not exists...eId = {}", eId);
            return;
        }

        Equipment equip = equips.get(0);
        String lng = String.valueOf(reqBody.getLongitude());
        String lat = String.valueOf(reqBody.getLatitude());

        if(!lng.equals(equip.geteLongitude()) || !lat.equals(equip.geteLatitude())) {
            Equipment tmpEquip = new Equipment();
            tmpEquip.seteLongitude(lng);
            tmpEquip.seteLatitude(lat);
            equipmentDao.updateData(eId, tmpEquip);
        }
    }

}
