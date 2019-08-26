package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.DataBody101;
import com.smart.sperms.api.protocol.DataBody102;
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
 * 处理101协议
 */
@Component
public class Handler101 extends Handler {

    @Autowired
    private EquipmentEnableDao equipmentEnableDao;

    @Override
    public void execute(String eId, MsgPayload req) {
        DataBody101 reqBody = (DataBody101)req.getData();
        logger.info("recv android msg...body = {}", reqBody);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_102.getCode());

        EquipmentEnableDto condition = new EquipmentEnableDto();
        condition.seteId(eId);

        List<EquipmentEnableDto> equipEnables = equipmentEnableDao.queryList(condition);

        if(CollectionUtils.isEmpty(equipEnables)) {
            logger.error("equipment is not enable...eId = {}", eId);

            DataBody102 respBody = new DataBody102();
            respBody.setWork(false);
            resp.setData(respBody);

            super.sendMsg(eId, resp);
            return;
        }

        EquipmentEnableDto enableDto = equipEnables.get(0);
        boolean work = false;
        if(enableDto.getEeEnable().intValue() == 1) {
            work = true;
        }
        DataBody102 respBody = new DataBody102();
        respBody.setWork(work);
        resp.setData(respBody);

        super.sendMsg(eId, resp);

        EquipmentEnable equipmentEnable = new EquipmentEnable();
        equipmentEnable.setEeCondition("firmwareVersion:"+ reqBody.getFirmwareVersion() + " softwareVersion:" + reqBody.getSoftwareVersion());
        equipmentEnableDao.updateData(eId, equipmentEnable);
    }

}
