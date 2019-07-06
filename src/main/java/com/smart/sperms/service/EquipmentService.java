package com.smart.sperms.service;

import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.EquipmentEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;

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

        int cnt = equipmentDao.saveData(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    public CommonWrapper updateInfo(EquipmentEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        Equipment info = new Equipment();
        info.seteManufacturer(req.geteManufacturer());
        info.seteName(req.geteName());
        info.seteStandard(req.geteStandard());
        info.seteType(req.geteType());
        info.seteDate(DateUtils.parseStrToDate(req.geteDate(), DateUtils.DEFAULT_FORMAT));

        int cnt = equipmentDao.updateData(req.geteId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    public CommonWrapper deleteInfo(List<String> eIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = equipmentDao.delData(eIds);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");
        }
        return wrapper;
    }

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
}
