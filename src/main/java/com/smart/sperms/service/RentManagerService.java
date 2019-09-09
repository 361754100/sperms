package com.smart.sperms.service;

import com.smart.sperms.dao.RentManagerDao;
import com.smart.sperms.dao.dto.RentManagerDto;
import com.smart.sperms.dao.model.RentManager;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.RentManagerEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class RentManagerService {

    @Autowired
    private RentManagerDao rentManagerDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(RentManagerEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String tradeNo = req.getTradeNo();
        boolean isExist = this.isExists(tradeNo);
        if(isExist) {
            wrapper.setResultMsg("该租赁信息已存在");
            return wrapper;
        }

        RentManager info = new RentManager();
        info.setCustomerNo(req.getCustomerNo());
        info.setCmNo(req.getCmNo());
        info.seteId(req.geteId());
        info.setCustomerNo(req.getCustomerNo());
        info.setRentPlace(req.getRentPlace());
        info.setTradeNo(req.getTradeNo());
        info.setRentBeginDate(DateUtils.parseStrToDate(req.getRentBeginDate(), DateUtils.DEFAULT_FORMAT));
        info.setRentDate(DateUtils.parseStrToDate(req.getRentDate(), DateUtils.DEFAULT_FORMAT));
        info.setRentEndDate(DateUtils.parseStrToDate(req.getRentEndDate(), DateUtils.DEFAULT_FORMAT));
        info.setAutoLock(req.getAutoLock());
        info.setLrMount(req.getLrMount());

        int cnt = rentManagerDao.saveData(info);
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
    public CommonWrapper updateInfo(RentManagerEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        RentManager info = new RentManager();
        info.setCustomerNo(req.getCustomerNo());
        info.setCmNo(req.getCmNo());
        info.seteId(req.geteId());
        info.setCustomerNo(req.getCustomerNo());
        info.setRentPlace(req.getRentPlace());
        info.setRentBeginDate(DateUtils.parseStrToDate(req.getRentBeginDate(), DateUtils.DEFAULT_FORMAT));
        info.setRentDate(DateUtils.parseStrToDate(req.getRentDate(), DateUtils.DEFAULT_FORMAT));
        info.setRentEndDate(DateUtils.parseStrToDate(req.getRentEndDate(), DateUtils.DEFAULT_FORMAT));
        info.setAutoLock(req.getAutoLock());
        info.setLrMount(req.getLrMount());

        int cnt = rentManagerDao.updateData(req.getTradeNo(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param tradeNos
     * @return
     */
    public CommonWrapper deleteInfo(List<String> tradeNos) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = rentManagerDao.delData(tradeNos);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @param tradeNo   交易编号
     * @param customerName  客户名称
     * @param equipmentName 设备名称
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String beginTime, String endTime,
                                       String tradeNo, String customerName, String equipmentName) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = rentManagerDao.queryPageTotal(beginTime, endTime, tradeNo, customerName, equipmentName);
        List<RentManagerDto> result = rentManagerDao.queryPage(pageNo, pageSize, beginTime, endTime,
                tradeNo, customerName, equipmentName);

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

        RentManager condition = new RentManager();
        condition.setTradeNo(recordId);

        List<RentManagerDto> result = rentManagerDao.queryDtoList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param tradeNo
     * @return
     */
    private boolean isExists(String tradeNo) {
        boolean isExist= false;
        RentManager condition = new RentManager();
        condition.setCustomerNo(tradeNo);

        List<RentManager> dataList = rentManagerDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
