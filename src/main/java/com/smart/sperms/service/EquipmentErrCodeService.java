package com.smart.sperms.service;

import com.smart.sperms.dao.EquipmentErrCodeDao;
import com.smart.sperms.dao.model.EquipmentErrCode;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.EquipmentErrCodeEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class EquipmentErrCodeService {

    @Autowired
    private EquipmentErrCodeDao errCodeDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(EquipmentErrCodeEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String errCode = req.getErrCode();
        boolean isExist = this.isExists(errCode);
        if(isExist) {
            wrapper.setResultMsg("该停机/锁机策略已存在");
            return wrapper;
        }
        EquipmentErrCode info = new EquipmentErrCode();
        info.setErrCode(req.getErrCode());
        info.setErrDesc(req.getErrDesc());
        info.setErrName(req.getErrName());

        int cnt = errCodeDao.saveData(info);
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
    public CommonWrapper updateInfo(EquipmentErrCodeEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        EquipmentErrCode info = new EquipmentErrCode();
        info.setErrDesc(req.getErrDesc());
        info.setErrName(req.getErrName());

        int cnt = errCodeDao.updateData(req.getErrCode(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param errCodes
     * @return
     */
    public CommonWrapper deleteInfo(List<String> errCodes) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = errCodeDao.delData(errCodes);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param keywords  关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String keywords) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = errCodeDao.queryPageTotal(keywords);
        List<EquipmentErrCode> result = errCodeDao.queryPage(pageNo, pageSize, keywords);

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

        EquipmentErrCode condition = new EquipmentErrCode();
        condition.setErrCode(recordId);

        List<EquipmentErrCode> result = errCodeDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param recordId
     * @return
     */
    private boolean isExists(String recordId) {
        boolean isExist= false;
        EquipmentErrCode condition = new EquipmentErrCode();
        condition.setErrCode(recordId);

        List<EquipmentErrCode> dataList = errCodeDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
