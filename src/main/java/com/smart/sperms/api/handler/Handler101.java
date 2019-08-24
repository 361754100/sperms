package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.DataBody101;
import com.smart.sperms.api.protocol.DataBody102;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
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
    private EquipmentDao equipmentDao;

    @Override
    public void execute(String eId, MsgPayload req) {
        DataBody101 reqBody = (DataBody101)req.getData();
        logger.info("recv android msg...body = {}", reqBody);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_102.getCode());

        Equipment condition = new Equipment();
        condition.seteId(eId);
        List<Equipment> equipments = equipmentDao.queryList(condition);

        if(CollectionUtils.isEmpty(equipments)) {
            logger.error("equipment is not exists...eId = {}", eId);

            resp.setCode(ProtocolEnum.CODE_ERROR.getCode());
            super.sendMsg(eId, resp);

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
        super.sendMsg(eId, resp);
    }

}
