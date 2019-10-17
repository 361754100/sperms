package com.smart.sperms.controller;

import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.service.MonitorPicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "monitor_pic", description = "设备监控图片")
@RestController
@RequestMapping(value = "monitor_pic")
public class MonitorPicController {

    private static Logger logger = LoggerFactory.getLogger(MonitorPicController.class);

    @Autowired
    private MonitorPicService monitorPicService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="eName", value = "设备名称关键字", paramType = "form", dataType = "string"),
            @ApiImplicitParam(name="eId", value = "设备ID", paramType = "form", dataType = "string")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime,
                                        @RequestParam int pageNo, @RequestParam int pageSize,
                                        @RequestParam(required = false) String eName,
                                        @RequestParam(required = false) String eId) {
        PageSearchWrapper wrapper = monitorPicService.queryPage(pageNo, pageSize,
                startTime, endTime, eName, eId);

        logger.debug("pageNo = {}, pageSize = {}, startTime = {}, endTime = {}, eName = {}, eId = {}",
                new Object[]{ pageNo, pageSize, startTime, endTime, eName, eId});
        return wrapper;
    }

}
