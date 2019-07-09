package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.CustomerMapper;
import com.smart.sperms.dao.model.Customer;
import com.smart.sperms.dao.model.CustomerExample;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDao.class);

    @Autowired
    private CustomerMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(Customer record) {
        int cnt = 0;
        try {
            cnt = mapper.insertSelective(record);
        } catch (Exception e) {
            logger.error("save data error...", e);
        }
        return cnt;
    }

    /**
     * 修改记录
     * @param recordId
     * @param record
     * @return
     */
    public int updateData(String recordId, Customer record) {
        int cnt = 0;
        try {
            CustomerExample example = new CustomerExample();
            example.createCriteria().andCustomerNoEqualTo(recordId);

            cnt = mapper.updateByExampleSelective(record, example);
        } catch (Exception e) {
            logger.error("update data error...", e);
        }
        return cnt;
    }

    /**
     * 删除记录
     * @param recordIds
     * @return
     */
    public int delData(List<String> recordIds) {
        int cnt = 0;
        try {
            CustomerExample example = new CustomerExample();
            example.createCriteria().andCustomerNoIn(recordIds);

            cnt = mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("delete data error...", e);
        }
        return cnt;
    }

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param beginTime
     * @param endTime
     * @param customerName
     * @return
     */
    public List<Customer> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String customerName) {
        int offset = (pageNo-1)*pageSize;
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(customerName)) {
            criteria.andCustomerNameLike("%" + customerName + "%");
        }
        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }

        List<Customer> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param beginTime
     * @param endTime
     * @param customerName
     * @return
     */
    public int queryPageTotal(String beginTime, String endTime, String customerName) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(customerName)) {
            criteria.andCustomerNameLike("%" + customerName + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<Customer> queryList(Customer condition) {
        List<Customer> result = null;
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();

        String customerNo = condition.getCustomerNo();
        if(!StringUtils.isEmpty(customerNo)) {
            criteria.andCustomerNoEqualTo(customerNo);
        }
        result = mapper.selectByExample(example);
        return result;
    }

}
