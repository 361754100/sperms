package com.smart.sperms.service;

import com.smart.sperms.dao.StoreDao;
import com.smart.sperms.dao.model.Store;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.StoreEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreDao storeDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(StoreEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String storeId = req.getStoreId();
        boolean isExist = this.isExists(storeId);
        if(isExist) {
            wrapper.setResultMsg("该仓库的信息已存在");
            return wrapper;
        }
        Store info = new Store();
        info.setStoreId(req.getStoreId());
        info.setStoreName(req.getStoreName());
        info.setStorePlace(req.getStorePlace());
        info.setCreationTime(new Date());

        int cnt = storeDao.saveData(info);
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
    public CommonWrapper updateInfo(StoreEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        Store info = new Store();
        info.setStoreId(req.getStoreId());
        info.setStoreName(req.getStoreName());
        info.setStorePlace(req.getStorePlace());
        info.setModifyTime(new Date());

        int cnt = storeDao.updateData(req.getStoreId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param storeIds
     * @return
     */
    public CommonWrapper deleteInfo(List<String> storeIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = storeDao.delData(storeIds);

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
     * @param keywords  关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String beginTime, String endTime, String keywords) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = storeDao.queryPageTotal(beginTime, endTime, keywords);
        List<Store> result = storeDao.queryPage(pageNo, pageSize, beginTime, endTime, keywords);

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

        Store condition = new Store();
        condition.setStoreId(recordId);

        List<Store> result = storeDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param storeId
     * @return
     */
    private boolean isExists(String storeId) {
        boolean isExist= false;
        Store condition = new Store();
        condition.setStoreId(storeId);

        List<Store> dataList = storeDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
