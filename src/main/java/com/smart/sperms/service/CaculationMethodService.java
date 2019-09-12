package com.smart.sperms.service;

import com.smart.sperms.dao.CaculationMethodDao;
import com.smart.sperms.dao.model.CaculationMethod;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.CaculationMethodEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class CaculationMethodService {

    @Autowired
    private CaculationMethodDao caculationMethodDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(CaculationMethodEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String cmNo = req.getCmNo();
        boolean isExist = this.isExists(cmNo);
        if(isExist) {
            wrapper.setResultMsg("该计费方式已存在");
            return wrapper;
        }
        CaculationMethod info = new CaculationMethod();
        info.setCmNo(req.getCmNo());
        info.setCmRemain(req.getCmRemain());
        info.setCmName(req.getCmName());
        info.setCmPrice(req.getCmPrice());
        info.setCmType(req.getCmType());
        info.setCmUnit(req.getCmUnit());

        int cnt = caculationMethodDao.saveData(info);
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
    public CommonWrapper updateInfo(CaculationMethodEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        CaculationMethod info = new CaculationMethod();
        info.setCmRemain(req.getCmRemain());
        info.setCmName(req.getCmName());
        info.setCmPrice(req.getCmPrice());
        info.setCmType(req.getCmType());
        info.setCmUnit(req.getCmUnit());

        int cnt = caculationMethodDao.updateData(req.getCmNo(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param cmNos
     * @return
     */
    public CommonWrapper deleteInfo(List<String> cmNos) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = caculationMethodDao.delData(cmNos);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param cmNo  关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String cmNo) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = caculationMethodDao.queryPageTotal(cmNo);
        List<CaculationMethod> result = caculationMethodDao.queryPage(pageNo, pageSize, cmNo);

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

        CaculationMethod condition = new CaculationMethod();
        condition.setCmNo(recordId);

        List<CaculationMethod> result = caculationMethodDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param cmNo
     * @return
     */
    private boolean isExists(String cmNo) {
        boolean isExist= false;
        CaculationMethod condition = new CaculationMethod();
        condition.setCmNo(cmNo);

        List<CaculationMethod> dataList = caculationMethodDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
