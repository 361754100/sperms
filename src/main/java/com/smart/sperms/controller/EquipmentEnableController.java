package com.smart.sperms.controller;

import com.smart.sperms.request.EquipmentEnableDelReq;
import com.smart.sperms.request.EquipmentEnableEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.EquipmentEnableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "equipment_enable", description = "设备信息")
@RestController
@RequestMapping(value = "equipment_enable")
public class EquipmentEnableController {

    private static Logger logger = LoggerFactory.getLogger(EquipmentEnableController.class);

    @Autowired
    private EquipmentEnableService equipmentEnableService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="e_enable", value = "应用授权（0：关停；1：正常使用）", paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="eName", value = "设备名称关键字", paramType = "form", dataType = "string")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam int pageNo, @RequestParam int pageSize,
                                        @RequestParam(required = false) Integer e_enable,
                                        @RequestParam(required = false) String eName) {
        if(e_enable == null) {
            e_enable = -1;
        }
        PageSearchWrapper wrapper = equipmentEnableService.queryPage(pageNo, pageSize, e_enable, eName);

        logger.debug("pageNo = {}, pageSize = {}, e_enable = {}",
                new Object[]{ pageNo, pageSize, e_enable});
        return wrapper;
    }

    @ApiOperation(value = "新增设备应用信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody EquipmentEnableEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = equipmentEnableService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改设备应用信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody EquipmentEnableEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = equipmentEnableService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除设备应用信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody EquipmentEnableDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = equipmentEnableService.deleteInfo(params.geteIds());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam String recordId) {
        SingleQueryWrapper wrapper = equipmentEnableService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }
}
