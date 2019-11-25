package com.smart.sperms.controller;

import com.smart.sperms.request.RentManagerAddReq;
import com.smart.sperms.request.RentManagerDelReq;
import com.smart.sperms.request.RentManagerEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.RentManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "rentmanager", description = "租赁信息")
@RestController
@RequestMapping(value = "rentmanager")
public class RentManagerController {

    private static Logger logger = LoggerFactory.getLogger(RentManagerController.class);

    @Autowired
    private RentManagerService rentManagerService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="tradeNo", value = "交易编号关键字", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="customerName", value = "客户名称关键字", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="equipmentName", value = "设备名称关键字", paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime,
                                        @RequestParam int pageNo, @RequestParam int pageSize,
                                        @RequestParam(required = false) String tradeNo,
                                        @RequestParam(required = false) String customerName,
                                        @RequestParam(required = false) String equipmentName) {
        PageSearchWrapper wrapper = rentManagerService.queryPage(pageNo, pageSize, startTime,
                endTime, tradeNo, customerName, equipmentName);

        logger.debug(" startTime = {}, endTime = {}, pageNo = {}, pageSize = {}, tradeNo = {}, customerName = {}, equipmentName = {}",
                new Object[]{startTime, endTime, pageNo, pageSize, tradeNo, customerName, equipmentName});
        return wrapper;
    }

    @ApiOperation(value = "新增租赁信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody RentManagerAddReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = rentManagerService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改租赁信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody RentManagerEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = rentManagerService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除租赁信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody RentManagerDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = rentManagerService.deleteInfo(params.getTradeNos());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam String recordId) {
        SingleQueryWrapper wrapper = rentManagerService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }
}
