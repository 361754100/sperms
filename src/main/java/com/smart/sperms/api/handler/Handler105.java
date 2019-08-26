package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.DataBody102;
import com.smart.sperms.api.protocol.DataBody105;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.dao.EquipmentEnableDao;
import com.smart.sperms.dao.dto.EquipmentEnableDto;
import com.smart.sperms.dao.model.EquipmentEnable;
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
    private EquipmentEnableDao equipmentEnableDao;

    @Override
    public void execute(String eId, MsgPayload req) {
        DataBody105 reqBody = (DataBody105)req.getData();
        logger.info("recv android msg...body = {}", reqBody);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_106.getCode());

        super.sendMsg(eId, resp);

        EquipmentEnableDto condition = new EquipmentEnableDto();
        condition.seteId(eId);

        List<EquipmentEnableDto> equipEnables = equipmentEnableDao.queryList(condition);
        if(CollectionUtils.isEmpty(equipEnables)) {
            logger.error("equipment enable is not exists...eId = {}", eId);
            return;
        }

        EquipmentEnableDto enableDto = equipEnables.get(0);
        String lng = String.valueOf(reqBody.getLongitude());
        String lat = String.valueOf(reqBody.getLatitude());

        if(!lng.equals(enableDto.getEeLongitude()) || !lat.equals(enableDto.getEeLatitude())) {
            EquipmentEnable equipmentEnable = new EquipmentEnable();
            equipmentEnable.setEeLongitude(lng);
            equipmentEnable.setEeLatitude(lat);
            equipmentEnableDao.updateData(eId, equipmentEnable);
        }
    }

}
