package com.smart.sperms.dao;

import com.smart.sperms.dao.dto.MonitorPicDto;
import com.smart.sperms.dao.mapper.MonitorPicMapper;
import com.smart.sperms.dao.model.MonitorPic;
import com.smart.sperms.dao.model.MonitorPicExample;
import com.smart.sperms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MonitorPicDao {

    private static final Logger logger = LoggerFactory.getLogger(MonitorPicDao.class);

    @Autowired
    private MonitorPicMapper mapper;

    /**
     * 新增记录
     * @param record
     * @return
     */
    public int saveData(MonitorPic record) {
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
    public int updateData(int recordId, MonitorPic record) {
        int cnt = 0;
        try {
            MonitorPicExample example = new MonitorPicExample();
            example.createCriteria().andPicIdEqualTo(recordId);

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
    public int delData(List<Integer> recordIds) {
        int cnt = 0;
        try {
            MonitorPicExample example = new MonitorPicExample();
            example.createCriteria().andPicIdIn(recordIds);

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
     * @param eName
     * @return
     */
    public List<MonitorPicDto> queryPage(int pageNo, int pageSize,
                                         String beginTime, String endTime,
                                         String eName, String eId) {
        int offset = (pageNo-1)*pageSize;
        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        if(!StringUtils.isEmpty(beginTime)) {
            params.put("beginTime", beginTime);
        }
        if(!StringUtils.isEmpty(endTime)) {
            params.put("endTime", endTime);
        }
        if(!StringUtils.isEmpty(eName)) {
            params.put("eName", eName);
        }
        if(!StringUtils.isEmpty(eId)) {
            params.put("eId", eId);
        }

        List<MonitorPicDto> result = mapper.selectDtoByConditionWithRowbounds(params);
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param beginTime
     * @param endTime
     * @param eName
     * @param eId
     * @return
     */
    public int queryPageTotal(String beginTime, String endTime, String eName, String eId) {
        Map<String, Object> params = new HashMap<>();
        if(!StringUtils.isEmpty(beginTime)) {
            params.put("beginTime", beginTime);
        }
        if(!StringUtils.isEmpty(endTime)) {
            params.put("endTime", endTime);
        }
        if(!StringUtils.isEmpty(eName)) {
            params.put("eName", eName);
        }
        if(!StringUtils.isEmpty(eId)) {
            params.put("eId", eId);
        }

        int total = mapper.countByCondition(params);
        return total;
    }

    /**
     * 条件查询
     * @param condition
     * @return
     */
    public List<MonitorPicDto> queryList(MonitorPicDto condition) {
        List<MonitorPicDto> result = null;
        Map<String, Object> params = new HashMap<>();
        if(!StringUtils.isEmpty(condition.geteId())) {
            params.put("eId", condition.geteId());
        }
        if(!StringUtils.isEmpty(condition.geteName())) {
            params.put("eName", condition.geteName());
        }
        result = mapper.selectDtoByCondition(params);
        return result;
    }

}
