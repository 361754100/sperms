package com.smart.sperms.service;

import com.smart.sperms.dao.CustomerDao;
import com.smart.sperms.dao.EquipmentDao;
import com.smart.sperms.dao.model.Customer;
import com.smart.sperms.dao.model.Equipment;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.CustomerEditReq;
import com.smart.sperms.request.EquipmentEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(CustomerEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String customerNo = req.getCustomerNo();
        boolean isExist = this.isExists(customerNo);
        if(isExist) {
            wrapper.setResultMsg("该客户信息已存在");
            return wrapper;
        }

        Customer info = new Customer();
        info.setCustomerNo(req.getCustomerNo());
        info.setCustomerSex(req.getCustomerSex());
        info.setCustomerPhone(req.getCustomerPhone());
        info.setCustomerName(req.getCustomerName());
        info.setCustomerEmail(req.getCustomerEmail());
        info.setCustomerCompany(req.getCustomerCompany());
        info.setCustomerAge(req.getCustomerAge());
        info.setCustomerAddr(req.getCustomerAddr());
        info.setCreationTime(new Date());

        int cnt = customerDao.saveData(info);
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
    public CommonWrapper updateInfo(CustomerEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        Customer info = new Customer();
        info.setCustomerAddr(req.getCustomerAddr());
        info.setCustomerAge(req.getCustomerAge());
        info.setCustomerCompany(req.getCustomerCompany());
        info.setCustomerEmail(req.getCustomerEmail());
        info.setCustomerName(req.getCustomerName());
        info.setCustomerPhone(req.getCustomerPhone());
        info.setCustomerSex(req.getCustomerSex());
        info.setModifyTime(new Date());

        int cnt = customerDao.updateData(req.getCustomerNo(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param customerNos
     * @return
     */
    public CommonWrapper deleteInfo(List<String> customerNos) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = customerDao.delData(customerNos);

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

        int total = customerDao.queryPageTotal(beginTime, endTime, keywords);
        List<Customer> result = customerDao.queryPage(pageNo, pageSize, beginTime, endTime, keywords);

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

        Customer condition = new Customer();
        condition.setCustomerNo(recordId);

        List<Customer> result = customerDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param customerNo
     * @return
     */
    private boolean isExists(String customerNo) {
        boolean isExist= false;
        Customer condition = new Customer();
        condition.setCustomerNo(customerNo);

        List<Customer> dataList = customerDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
