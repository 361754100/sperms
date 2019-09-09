package com.smart.sperms.dao;

import com.smart.sperms.dao.mapper.EquipmentErrCodeMapper;
import com.smart.sperms.dao.model.EquipmentErrCode;
import com.smart.sperms.dao.model.EquipmentErrCodeExample;
import com.smart.sperms.utils.RowBoundsUtil;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentErrCodeDao {

    private static final Logger logger = LoggerFactory.getLogger(EquipmentErrCodeDao.class);

    @Autowired
    private EquipmentErrCodeMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(EquipmentErrCode record) {
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
    public int updateData(String recordId, EquipmentErrCode record) {
        int cnt = 0;
        try {
            EquipmentErrCodeExample example = new EquipmentErrCodeExample();
            example.createCriteria().andErrCodeEqualTo(recordId);

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
            EquipmentErrCodeExample example = new EquipmentErrCodeExample();
            example.createCriteria().andErrCodeIn(recordIds);

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
     * @param errName
     * @return
     */
    public List<EquipmentErrCode> queryPage(int pageNo, int pageSize, String errName) {
        int offset = (pageNo-1)*pageSize;
        EquipmentErrCodeExample example = new EquipmentErrCodeExample();
        EquipmentErrCodeExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(errName)) {
            criteria.andErrNameLike("%" + errName + "%");
        }

        List<EquipmentErrCode> result = mapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param errName
     * @return
     */
    public int queryPageTotal(String errName) {
        EquipmentErrCodeExample example = new EquipmentErrCodeExample();
        EquipmentErrCodeExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(errName)) {
            criteria.andErrNameLike("%" + errName + "%");
        }

        int total = mapper.countByExample(example);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<EquipmentErrCode> queryList(EquipmentErrCode condition) {
        List<EquipmentErrCode> result = null;
        EquipmentErrCodeExample example = new EquipmentErrCodeExample();
        EquipmentErrCodeExample.Criteria criteria = example.createCriteria();

        String errCode = condition.getErrCode();
        if(!StringUtils.isEmpty(errCode)) {
            criteria.andErrCodeEqualTo(errCode);
        }
        result = mapper.selectByExample(example);
        return result;
    }

}
