package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.ProductMapper;
import com.smart.sperms.dao.model.Product;
import com.smart.sperms.dao.model.ProductExample;
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
public class ProductDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);

    @Autowired
    private ProductMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(Product record) {
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
    public int updateData(String recordId, Product record) {
        int cnt = 0;
        try {
            ProductExample example = new ProductExample();
            example.createCriteria().andProIdEqualTo(recordId);

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
            ProductExample example = new ProductExample();
            example.createCriteria().andProIdIn(recordIds);

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
     * @param proName
     * @return
     */
    public List<Product> queryPage(int pageNo, int pageSize, String proName) {
        int offset = (pageNo-1)*pageSize;

        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(proName)) {
            criteria.andProNameLike("%"+ proName + "%");
        }

        List<Product> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param proName
     * @return
     */
    public int queryPageTotal(String proName) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(proName)) {
            criteria.andProNameLike("%"+ proName + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<Product> queryList(Product condition) {
        List<Product> result = null;

        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(condition.getProName())) {
            criteria.andProNameLike("%"+ condition.getProName() + "%");
        }

        if(!StringUtils.isEmpty(condition.getProId())) {
            criteria.andProIdEqualTo(condition.getProId());
        }

        result = mapper.selectByExample(example);
        return result;
    }

    /**
     * 条件查询
     * @return
     */
    public Map<String, Product> queryProMap() {
        Map<String, Product> rtMap = new HashMap<>();

        ProductExample example = new ProductExample();

        List<Product> result = mapper.selectByExample(example);
        if(CollectionUtils.isEmpty(result)) {
            return rtMap;
        }
        for(Product prod: result) {
            rtMap.put(prod.getProId(), prod);
        }
        return rtMap;
    }

    /**
     * 查询所有
     * @return
     */
    public List<Product> listAll() {
        ProductExample example = new ProductExample();

        List<Product> result = mapper.selectByExample(example);
        return result;
    }

}
