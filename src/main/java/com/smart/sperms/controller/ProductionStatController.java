package com.smart.sperms.controller;

import com.smart.sperms.request.ProductionStatDelReq;
import com.smart.sperms.request.ProductionStatEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.ProductionStatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "production_stat", description = "生产统计信息")
@RestController
@RequestMapping(value = "production_stat")
public class ProductionStatController {

    private static Logger logger = LoggerFactory.getLogger(ProductionStatController.class);

    @Autowired
    private ProductionStatService productionStatService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="eName", value = "设备名称关键字", paramType = "form", dataType = "string")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime,
                                        @RequestParam int pageNo, @RequestParam int pageSize,
                                        @RequestParam(required = false) String eName) {
        PageSearchWrapper wrapper = productionStatService.queryPage(pageNo, pageSize, startTime, endTime, eName);

        logger.debug("pageNo = {}, pageSize = {}, startTime = {}, endTime = {}, eName = {}",
                new Object[]{ pageNo, pageSize, startTime, endTime, eName});
        return wrapper;
    }

    @ApiOperation(value = "新增生产统计信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody ProductionStatEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = productionStatService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改生产统计信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody ProductionStatEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = productionStatService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除生产统计信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody ProductionStatDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = productionStatService.deleteInfo(params.geteIds());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam String recordId) {
        SingleQueryWrapper wrapper = productionStatService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }
}
