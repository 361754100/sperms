package com.smart.sperms.service;

import com.smart.sperms.api.handler.Handler107;
import com.smart.sperms.api.handler.Handler111;
import com.smart.sperms.api.protocol.DataBody107;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.common.SpringContext;
import com.smart.sperms.config.mqtt.MqttInputHandler;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.dao.model.EquipmentExample;
import com.smart.sperms.enums.DevEnableEnum;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.EquipmentEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class EquipmentService {

    private static Logger logger = LoggerFactory.getLogger(EquipmentService.class);

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private MqttInputHandler mqttInputHandler;
    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(EquipmentEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String eId = req.geteId();
        boolean isExist = this.isExists(eId);
        if(isExist) {
            wrapper.setResultMsg("该设备信息已存在");
            return wrapper;
        }
        Date date = new Date();
        Equipment info = new Equipment();
        info.seteId(req.geteId());
        info.seteManufacturer(req.geteManufacturer());
        info.seteName(req.geteName());
        info.seteStandard(req.geteStandard());
        info.seteType(req.geteType());
        info.seteDate(DateUtils.parseStrToDate(req.geteDate(), DateUtils.DEFAULT_FORMAT));
        info.seteEnable(req.geteEnable());
        info.seteLatitude(req.geteLatitude());
        info.seteLongitude(req.geteLongitude());

        int cnt = equipmentDao.saveData(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
            // 订阅设备消息
            mqttInputHandler.addListenTopic(eId);
            this.controlDev(eId, req.geteEnable().intValue());
        }
        return wrapper;
    }

    /**
     * 修改记录
     * @param req
     * @return
     */
    public CommonWrapper updateInfo(EquipmentEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        Equipment info = new Equipment();
        info.seteManufacturer(req.geteManufacturer());
        info.seteName(req.geteName());
        info.seteStandard(req.geteStandard());
        info.seteType(req.geteType());
        info.seteDate(DateUtils.parseStrToDate(req.geteDate(), DateUtils.DEFAULT_FORMAT));
        info.seteEnable(req.geteEnable());
        info.seteLatitude(req.geteLatitude());
        info.seteLongitude(req.geteLongitude());

        int cnt = equipmentDao.updateData(req.geteId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());

            this.controlDev(req.geteId(), req.geteEnable().intValue());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param eIds
     * @return
     */
    public CommonWrapper deleteInfo(List<String> eIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = equipmentDao.delData(eIds);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        if(cnt > 0 ) {
            for(String eId: eIds) {
                mqttInputHandler.removeListenTopic(eId);

                this.controlDev(eId, DevEnableEnum.STOP.getCode());
            }
        }
        return wrapper;
    }

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @param keywords  关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String beginTime, String endTime, String keywords) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = equipmentDao.queryPageTotal(beginTime, endTime, keywords);
        List<Equipment> result = equipmentDao.queryPage(pageNo, pageSize, beginTime, endTime, keywords);

        wrapper.setTotalCount(total);
        wrapper.setPageNo(pageNo);
        wrapper.setRecords(result);
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 查询单个结果
     * @param recordId
     * @return
     */
    public SingleQueryWrapper findRecordById(String recordId) {
        SingleQueryWrapper wrapper = new SingleQueryWrapper();

        Equipment condition = new Equipment();
        condition.seteId(recordId);

        List<Equipment> result = equipmentDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param eId
     * @return
     */
    private boolean isExists(String eId) {
        boolean isExist= false;
        Equipment condition = new Equipment();
        condition.seteId(eId);

        List<Equipment> dataList = equipmentDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }

    /**
     * 批量启停设备
     * @param eIds
     * @param enable
     */
    public CommonWrapper controlDevs(List<String> eIds, int enable) {
        EquipmentExample example = new EquipmentExample();
        example.createCriteria().andEIdIn(eIds);

        Equipment record = new Equipment();
        record.seteEnable(enable);

        CommonWrapper wrapper = new CommonWrapper();
        int cnt = equipmentDao.updateByExample(example, record);
        wrapper.setResultMsg("成功设置【"+ cnt +"】台设备");

        for(String eId: eIds) {
            this.controlDev(eId, enable);
        }

        return wrapper;
    }

    /**
     * 设备拍照
     * @param eIds
     */
    public CommonWrapper takePicture(List<String> eIds) {
        CommonWrapper wrapper = new CommonWrapper();

        Handler111 handler = SpringContext.getBean(Handler111.class);

        MsgPayload payload = new MsgPayload();
        payload.setProtocol(ProtocolEnum.CODE_111.getCode());

        for(String eId: eIds) {
            handler.execute(eId, payload);
        }

        return wrapper;
    }

    /**
     * 控制设备启停
     * @param eId
     * @param enable
     */
    private void controlDev(String eId, int enable) {
        // 开启Or关闭设备
        DevEnableEnum devEnableEnum = DevEnableEnum.getResult(enable);

        MsgPayload payload = new MsgPayload();
        DataBody107 dataBody = new DataBody107();
        // 发消息给安卓端
        switch (devEnableEnum) {
            case STOP:
                dataBody.setWork(false);
                break;
            case TURN_ON:
                dataBody.setWork(true);
                break;
        }
        payload.setProtocol(ProtocolEnum.CODE_107.getCode());
        payload.setData(dataBody);

        Handler107 handler = new Handler107();
        handler.execute(eId, payload);

        logger.debug("control dev dataBody...{}", dataBody);
    }
}
