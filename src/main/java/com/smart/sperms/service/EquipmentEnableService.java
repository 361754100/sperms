package com.smart.sperms.service;

import com.smart.sperms.api.handler.Handler107;
import com.smart.sperms.api.protocol.DataBody107;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.common.SpringContext;
import com.smart.sperms.dao.EquipmentEnableDao;
import com.smart.sperms.dao.dto.EquipmentEnableDto;
import com.smart.sperms.dao.model.EquipmentEnable;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.EquipmentEnableEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class EquipmentEnableService {

    private static Logger logger = LoggerFactory.getLogger(EquipmentEnableService.class);

    @Autowired
    private EquipmentEnableDao equipmentEnableDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(EquipmentEnableEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String eId = req.geteId();
        boolean isExist = this.isExists(eId);
        if(isExist) {
            wrapper.setResultMsg("该应用信息已存在");
            return wrapper;
        }
        EquipmentEnable info = new EquipmentEnable();
        info.seteId(req.geteId());
        info.setEeCondition(req.getEeCondition());
        info.setEeEnable(req.getEeEnable());
        info.setEeLatitude(req.getEeLatitude());
        info.setEeLongitude(req.getEeLongitude());

        int cnt = equipmentEnableDao.saveData(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 修改记录
     * @param req
     * @return
     */
    public CommonWrapper updateInfo(EquipmentEnableEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        EquipmentEnable info = new EquipmentEnable();
        info.setEeLongitude(req.getEeLongitude());
        info.setEeLatitude(req.getEeLatitude());
        info.setEeEnable(req.getEeEnable());
        info.setEeCondition(req.getEeCondition());

        EquipmentEnableDto queryCondition = new EquipmentEnableDto();
        List<EquipmentEnableDto> tmpList = equipmentEnableDao.queryList(queryCondition);

        int cnt = equipmentEnableDao.updateData(req.geteId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());

            if(!CollectionUtils.isEmpty(tmpList)) {
                EquipmentEnableDto enableDto = tmpList.get(0);
                int isEnable = req.getEeEnable().intValue();
                // 如果新旧状态不一致，则把新状态发送给设备
                if(enableDto.getEeEnable().intValue() != isEnable) {
                    boolean work = isEnable == 1?true:false;
                    logger.info("change device work state...work ={}", work);

                    DataBody107 body107 = new DataBody107();
                    body107.setWork(work);

                    MsgPayload payload = new MsgPayload();
                    payload.setData(body107);
                    payload.setProtocol(ProtocolEnum.CODE_107.getCode());

                    Handler107 handler107 = SpringContext.getBean(Handler107.class);
                    handler107.execute(req.geteId(), payload);
                }
            }
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
        int cnt = equipmentEnableDao.delData(eIds);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        for(String eId: eIds) {
            boolean work = false;
            logger.info("delete device and change work state...work ={}", work);

            DataBody107 body107 = new DataBody107();
            body107.setWork(work);

            MsgPayload payload = new MsgPayload();
            payload.setData(body107);
            payload.setProtocol(ProtocolEnum.CODE_107.getCode());

            Handler107 handler107 = SpringContext.getBean(Handler107.class);
            handler107.execute(eId, payload);
        }
        return wrapper;
    }

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param e_enable  应用授权
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, int e_enable, String eName) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = equipmentEnableDao.queryPageTotal(e_enable, eName);
        List<EquipmentEnableDto> result = equipmentEnableDao.queryPage(pageNo, pageSize, e_enable, eName);

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

        EquipmentEnableDto condition = new EquipmentEnableDto();
        condition.seteId(recordId);

        List<EquipmentEnableDto> result = equipmentEnableDao.queryList(condition);
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
        EquipmentEnableDto condition = new EquipmentEnableDto();
        condition.seteId(eId);

        List<EquipmentEnableDto> dataList = equipmentEnableDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
