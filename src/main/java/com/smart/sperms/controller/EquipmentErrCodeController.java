package com.smart.sperms.controller;

import com.smart.sperms.request.EquipmentErrCodeDelReq;
import com.smart.sperms.request.EquipmentErrCodeEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.EquipmentErrCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "equiperr", description = "设备故障信息")
@RestController
@RequestMapping(value = "equiperr")
public class EquipmentErrCodeController {

    private static Logger logger = LoggerFactory.getLogger(EquipmentErrCodeController.class);

    @Autowired
    private EquipmentErrCodeService errCodeService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="keywords", value = "关键字", paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam(required = false) String keywords) {
        PageSearchWrapper wrapper = errCodeService.queryPage(pageNo, pageSize, keywords);

        logger.debug(" pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{pageNo, pageSize, keywords});
        return wrapper;
    }

    @ApiOperation(value = "新增设备故障信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody EquipmentErrCodeEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = errCodeService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改设备故障信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody EquipmentErrCodeEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = errCodeService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除设备故障信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody EquipmentErrCodeDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = errCodeService.deleteInfo(params.getErrCodes());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam String recordId) {
        SingleQueryWrapper wrapper = errCodeService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }
}
