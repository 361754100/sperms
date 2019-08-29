package com.smart.sperms.dao;

import com.smart.sperms.dao.dto.UsersDto;
import com.smart.sperms.dao.mapper.UsersMapper;
import com.smart.sperms.dao.model.Users;
import com.smart.sperms.dao.model.UsersExample;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsersDao {

    private static final Logger logger = LoggerFactory.getLogger(EquipmentDao.class);

    @Autowired
    private UsersMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(Users record) {
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
    public int updateData(String recordId, Users record) {
        int cnt = 0;
        try {
            UsersExample example = new UsersExample();
            example.createCriteria().andUIdEqualTo(recordId);

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
            UsersExample example = new UsersExample();
            example.createCriteria().andUIdIn(recordIds)
            .andUIdNotEqualTo("admin");

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
     * @param uName
     * @return
     */
    public List<UsersDto> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String uName) {
        int offset = (pageNo-1)*pageSize;

        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("pageSize", pageSize);

        if(!StringUtils.isEmpty(uName)) {
            params.put("uName", uName);
        }
        if(!StringUtils.isEmpty(beginTime)) {
            params.put("beginTime", beginTime);
        }
        if(!StringUtils.isEmpty(endTime)) {
            params.put("endTime", endTime);
        }

        List<UsersDto> result = mapper.selectDtoByConditionWithRowbounds(params);
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param beginTime
     * @param endTime
     * @param uName
     * @return
     */
    public int queryPageTotal(String beginTime, String endTime, String uName) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(uName)) {
            criteria.andUNameLike("%" + uName + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<Users> queryList(Users condition) {
        List<Users> result = null;
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();

        String uId = condition.getuId();
        if(!StringUtils.isEmpty(uId)) {
            criteria.andUIdEqualTo(uId);
        }
        result = mapper.selectByExample(example);
        return result;
    }

    /**
     * 条件查询
     * @param example
     * @return
     */
    public List<Users> queryListByExample(UsersExample example) {
        List<Users> result = mapper.selectByExample(example);
        return result;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public Users querySingle(Users condition) {
        Users users = null;
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();

        String uId = condition.getuId();
        if(!StringUtils.isEmpty(uId)) {
            criteria.andUIdEqualTo(uId);
        }
        List<Users> result = mapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(result)) {
            users = result.get(0);
        }
        return users;
    }
}
