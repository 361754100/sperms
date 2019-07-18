package com.smart.sperms.controller;

import com.smart.sperms.request.CustomerDelReq;
import com.smart.sperms.request.CustomerEditReq;
import com.smart.sperms.request.EquipmentDelReq;
import com.smart.sperms.request.EquipmentEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.CustomerService;
import com.smart.sperms.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "customer", description = "客户信息")
@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="keywords", value = "关键字", paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam String startTime, @RequestParam String endTime,
                                        @RequestParam int pageNo, @RequestParam int pageSize, @RequestParam(required = false) String keywords) {
        PageSearchWrapper wrapper = customerService.queryPage(pageNo, pageSize, startTime, endTime, keywords);

        logger.debug(" startTime = {}, endTime = {}, pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{startTime, endTime, pageNo, pageSize, keywords});
        return wrapper;
    }

    @ApiOperation(value = "新增客户信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody CustomerEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = customerService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改客户信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody CustomerEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = customerService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除客户信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody CustomerDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = customerService.deleteInfo(params.getCustomerNos());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam String recordId) {
        SingleQueryWrapper wrapper = customerService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }
}
