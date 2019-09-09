package com.smart.sperms.service;

import com.smart.sperms.dao.LockRuleDao;
import com.smart.sperms.dao.model.LockRule;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.LockRuleEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class LockRuleService {

    @Autowired
    private LockRuleDao lockRuleDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(LockRuleEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String lrNo = req.getLrNo();
        boolean isExist = this.isExists(lrNo);
        if(isExist) {
            wrapper.setResultMsg("该停机/锁机策略已存在");
            return wrapper;
        }
        LockRule info = new LockRule();
        info.setLrNo(req.getLrNo());
        info.setLrName(req.getLrName());
        info.setLrType(req.getLrType());
        info.setLrTotal(req.getLrTotal());
        info.setLrUnit(req.getLrUnit());

        int cnt = lockRuleDao.saveData(info);
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
    public CommonWrapper updateInfo(LockRuleEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        LockRule info = new LockRule();
        info.setLrName(req.getLrName());
        info.setLrType(req.getLrType());
        info.setLrTotal(req.getLrTotal());
        info.setLrUnit(req.getLrUnit());

        int cnt = lockRuleDao.updateData(req.getLrNo(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param lrNos
     * @return
     */
    public CommonWrapper deleteInfo(List<String> lrNos) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = lockRuleDao.delData(lrNos);

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

        int total = lockRuleDao.queryPageTotal(keywords);
        List<LockRule> result = lockRuleDao.queryPage(pageNo, pageSize, keywords);

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

        LockRule condition = new LockRule();
        condition.setLrNo(recordId);

        List<LockRule> result = lockRuleDao.queryList(condition);
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
        LockRule condition = new LockRule();
        condition.setLrNo(recordId);

        List<LockRule> dataList = lockRuleDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
