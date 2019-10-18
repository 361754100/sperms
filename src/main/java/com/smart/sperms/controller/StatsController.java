package com.smart.sperms.controller;

import com.smart.sperms.response.ListQueryWrapper;
import com.smart.sperms.service.StatsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "stats", description = "数据统计")
@RestController
@RequestMapping(value = "stats")
public class StatsController {

    private static Logger logger = LoggerFactory.getLogger(StatsController.class);

    @Autowired
    private StatsService statsService;

    @ApiOperation(value = "销售额统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/sales_account")
    public ListQueryWrapper salesAccount(@RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime) {
        ListQueryWrapper wrapper = statsService.salesAccount(startTime, endTime);

        logger.debug(" startTime = {}, endTime = {}", new Object[]{startTime, endTime});
        return wrapper;
    }

    @ApiOperation(value = "产量统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="customerNo", value = "客户编号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="eId", value = "设备编号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="statType", value = "统计方式（1=按天，2=按月）", required = true, paramType = "form", dataType = "int")

    })
    @PostMapping(value = "/prod_mount")
    public ListQueryWrapper produceMount(@RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime,
                                         @RequestParam(required = false) String customerNo, @RequestParam(required = false) String eId,
                                         @RequestParam int statType) {
        ListQueryWrapper wrapper = statsService.prodMount(statType, startTime, endTime, customerNo, eId);

        logger.debug(" statType = {}, startTime = {}, endTime = {}, customerNo = {}, customerName = {}", new Object[]{statType, startTime, endTime, customerNo, eId});
        return wrapper;
    }

    @ApiOperation(value = "产品类型产量统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="customerNo", value = "客户编号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="eId", value = "设备编号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="statType", value = "统计方式（1=按天，2=按月）", required = true, paramType = "form", dataType = "int")

    })
    @PostMapping(value = "/prod_mount_by_type")
    public ListQueryWrapper produceMountByType(@RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime,
                                         @RequestParam(required = false) String customerNo, @RequestParam(required = false) String eId,
                                         @RequestParam int statType) {
        ListQueryWrapper wrapper = statsService.prodMountByType(statType, startTime, endTime, customerNo, eId);

        logger.debug(" statType = {}, startTime = {}, endTime = {}, customerNo = {}, eId = {}", new Object[]{statType, startTime, endTime, customerNo, eId});
        return wrapper;
    }

    @ApiOperation(value = "设备状态统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/dev_state")
    public ListQueryWrapper devStateAccount(@RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime) {
        ListQueryWrapper wrapper = statsService.devStateAccount(startTime, endTime);

        logger.debug(" startTime = {}, endTime = {}", new Object[]{startTime, endTime});
        return wrapper;
    }

}
