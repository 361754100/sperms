package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.UsersCustomerRelationMapper;
import com.smart.sperms.dao.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserCustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(UserCustomerDao.class);

    @Autowired
    private UsersCustomerRelationMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(UsersCustomerRelation record) {
        int cnt = 0;
        try {
            cnt = mapper.insertSelective(record);
        } catch (Exception e) {
            logger.error("save data error...", e);
        }
        return cnt;
    }

    /**
     * 删除客户与系统用户的关联记录
     * @param customerNos
     * @return
     */
    public int delRelationByCustomerNos(List<String> customerNos) {
        int cnt = 0;
        try {
            UsersCustomerRelationExample example = new UsersCustomerRelationExample();
            example.createCriteria().andCustomerNoIn(customerNos);

            cnt = mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("delete data error...", e);
        }
        return cnt;
    }

    /**
     * 删除客户与系统用户的关联记录
     * @param customerNo
     * @param userId
     * @return
     */
    public int delRelationByCustomerUserId(String customerNo, String userId) {
        int cnt = 0;
        try {
            UsersCustomerRelationExample example = new UsersCustomerRelationExample();
            example.createCriteria().andCustomerNoEqualTo(customerNo).andUIdEqualTo(userId);

            cnt = mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("delete data error...", e);
        }
        return cnt;
    }

    /**
     * 根据客户编号查询用户信息
     * @param customerNo
     * @return
     */
    public List<Users> queryUsersByCustomerNo(String customerNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerNo", customerNo);

        List<Users> usersList = mapper.selectUserByCustomerNo(params);
        return usersList;
    }

    /**
     * 根据用户ID查询客户信息
     * @param uId
     * @return
     */
    public List<Customer> queryCustomerByUserId(String uId) {
        Map<String, Object> params = new HashMap<>();
        params.put("uId", uId);

        List<Customer> customers = mapper.selectCustomerByUid(params);
        return customers;
    }

}
