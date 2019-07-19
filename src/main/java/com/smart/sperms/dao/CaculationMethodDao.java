package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.CaculationMethodMapper;
import com.smart.sperms.dao.model.CaculationMethod;
import com.smart.sperms.dao.model.CaculationMethodExample;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CaculationMethodDao {

    private static final Logger logger = LoggerFactory.getLogger(CaculationMethodDao.class);

    @Autowired
    private CaculationMethodMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(CaculationMethod record) {
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
    public int updateData(String recordId, CaculationMethod record) {
        int cnt = 0;
        try {
            CaculationMethodExample example = new CaculationMethodExample();
            example.createCriteria().andCmNoEqualTo(recordId);

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
            CaculationMethodExample example = new CaculationMethodExample();
            example.createCriteria().andCmNoIn(recordIds);

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
     * @param cm_no
     * @return
     */
    public List<CaculationMethod> queryPage(int pageNo, int pageSize, String cm_no) {
        int offset = (pageNo-1)*pageSize;
        CaculationMethodExample example = new CaculationMethodExample();
        CaculationMethodExample.Criteria criteria =  example.createCriteria();
        if(!StringUtils.isEmpty(cm_no)) {
            criteria.andCmNoLike(cm_no);
        }

        List<CaculationMethod> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param cm_no
     * @return
     */
    public int queryPageTotal(String cm_no) {
        CaculationMethodExample example = new CaculationMethodExample();
        CaculationMethodExample.Criteria criteria =  example.createCriteria();
        if(!StringUtils.isEmpty(cm_no)) {
            criteria.andCmNoLike(cm_no);
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<CaculationMethod> queryList(CaculationMethod condition) {
        List<CaculationMethod> result = null;

        CaculationMethodExample example = new CaculationMethodExample();
        CaculationMethodExample.Criteria criteria =  example.createCriteria();

        if(!StringUtils.isEmpty(condition.getCmNo())) {
            criteria.andCmNoLike(condition.getCmNo());
        }

        result = mapper.selectByExample(example);
        return result;
    }

}
