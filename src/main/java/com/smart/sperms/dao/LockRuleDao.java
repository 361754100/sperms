package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.LockRuleMapper;
import com.smart.sperms.dao.model.LockRule;
import com.smart.sperms.dao.model.LockRuleExample;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LockRuleDao {

    private static final Logger logger = LoggerFactory.getLogger(LockRuleDao.class);

    @Autowired
    private LockRuleMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(LockRule record) {
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
    public int updateData(String recordId, LockRule record) {
        int cnt = 0;
        try {
            LockRuleExample example = new LockRuleExample();
            example.createCriteria().andLrNoEqualTo(recordId);

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
            LockRuleExample example = new LockRuleExample();
            example.createCriteria().andLrNoIn(recordIds);

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
     * @param lrName
     * @return
     */
    public List<LockRule> queryPage(int pageNo, int pageSize, String lrName) {
        int offset = (pageNo-1)*pageSize;
        LockRuleExample example = new LockRuleExample();
        LockRuleExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(lrName)) {
            criteria.andLrNameLike("%" + lrName + "%");
        }

        List<LockRule> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param lrName
     * @return
     */
    public int queryPageTotal(String lrName) {
        LockRuleExample example = new LockRuleExample();
        LockRuleExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(lrName)) {
            criteria.andLrNameLike("%" + lrName + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<LockRule> queryList(LockRule condition) {
        List<LockRule> result = null;
        LockRuleExample example = new LockRuleExample();
        LockRuleExample.Criteria criteria = example.createCriteria();

        String lrNo = condition.getLrNo();
        if(!StringUtils.isEmpty(lrNo)) {
            criteria.andLrNoEqualTo(lrNo);
        }
        result = mapper.selectByExample(example);
        return result;
    }

}
