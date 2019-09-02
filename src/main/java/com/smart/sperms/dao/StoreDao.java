package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.StoreMapper;
import com.smart.sperms.dao.model.StoreExample;
import com.smart.sperms.dao.model.Store;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDao {

    private static final Logger logger = LoggerFactory.getLogger(StoreDao.class);

    @Autowired
    private StoreMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(Store record) {
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
    public int updateData(String recordId, Store record) {
        int cnt = 0;
        try {
            StoreExample example = new StoreExample();
            example.createCriteria().andStoreIdEqualTo(recordId);

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
            StoreExample example = new StoreExample();
            example.createCriteria().andStoreIdIn(recordIds);

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
     * @param storeName
     * @return
     */
    public List<Store> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String storeName) {
        int offset = (pageNo-1)*pageSize;
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(storeName)) {
            criteria.andStoreNameLike("%" + storeName + "%");
        }
        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }

        List<Store> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param beginTime
     * @param endTime
     * @param storeName
     * @return
     */
    public int queryPageTotal(String beginTime, String endTime, String storeName) {
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(storeName)) {
            criteria.andStoreNameLike("%" + storeName + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<Store> queryList(Store condition) {
        List<Store> result = null;
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();

        String storeId = condition.getStoreId();
        if(!StringUtils.isEmpty(storeId)) {
            criteria.andStoreIdEqualTo(storeId);
        }
        result = mapper.selectByExample(example);
        return result;
    }

}
