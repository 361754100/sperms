package com.smart.sperms.service;

import com.smart.sperms.dao.MonitorPicDao;
import com.smart.sperms.dao.dto.MonitorPicDto;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.response.PageSearchWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorPicService {

    @Autowired
    private MonitorPicDao monitorPicDao;

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param beginTime
     * @param endTime
     * @param eName
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize,
                                       String beginTime, String endTime,
                                       String eName, String eId) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = monitorPicDao.queryPageTotal(beginTime, endTime, eName, eId);
        List<MonitorPicDto> result = monitorPicDao.queryPage(pageNo, pageSize, beginTime, endTime, eName, eId);

        wrapper.setTotalCount(total);
        wrapper.setPageNo(pageNo);
        wrapper.setRecords(result);
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

}
