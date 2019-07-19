package com.smart.sperms.service;

import com.smart.sperms.dao.ProductionStatDao;
import com.smart.sperms.dao.dto.ProductionStatDto;
import com.smart.sperms.dao.model.ProductionStat;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.ProductionStatEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProductionStatService {

    @Autowired
    private ProductionStatDao productionStatDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(ProductionStatEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String eId = req.geteId();
        boolean isExist = this.isExists(eId);
        if(isExist) {
            wrapper.setResultMsg("该应用信息已存在");
            return wrapper;
        }
        ProductionStat info = new ProductionStat();
        info.seteId(req.geteId());
        info.setPsMount(req.getPsMount());
        info.setPsDate(DateUtils.parseStrToDate(req.getPsDate(), DateUtils.DEFAULT_FORMAT));
        info.setPsEndDate(DateUtils.parseStrToDate(req.getPsEndDate(), DateUtils.DEFAULT_FORMAT));

        int cnt = productionStatDao.saveData(info);
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
    public CommonWrapper updateInfo(ProductionStatEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        ProductionStat info = new ProductionStat();
        info.setPsDate(DateUtils.parseStrToDate(req.getPsDate(), DateUtils.DEFAULT_FORMAT));
        info.setPsEndDate(DateUtils.parseStrToDate(req.getPsEndDate(), DateUtils.DEFAULT_FORMAT));
        info.setPsMount(req.getPsMount());

        int cnt = productionStatDao.updateData(req.geteId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
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
        int cnt = productionStatDao.delData(eIds);

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
     * @param eName     设备名称关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String beginTime, String endTime, String eName) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = productionStatDao.queryPageTotal(beginTime, endTime, eName);
        List<ProductionStatDto> result = productionStatDao.queryPage(pageNo, pageSize, beginTime, endTime, eName);

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

        ProductionStatDto condition = new ProductionStatDto();
        condition.seteId(recordId);

        List<ProductionStatDto> result = productionStatDao.queryList(condition);
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
        ProductionStatDto condition = new ProductionStatDto();
        condition.seteId(eId);

        List<ProductionStatDto> dataList = productionStatDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
