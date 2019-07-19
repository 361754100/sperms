package com.smart.sperms.controller;

import com.smart.sperms.request.CaculationMethodDelReq;
import com.smart.sperms.request.CaculationMethodEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.CaculationMethodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "caculation_method", description = "计费方式")
@RestController
@RequestMapping(value = "caculation_method")
public class CaculationMethodController {

    private static Logger logger = LoggerFactory.getLogger(CaculationMethodController.class);

    @Autowired
    private CaculationMethodService caculationMethodService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="cmNo", value = "计费编号关键字", paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam(required = false) String cmNo) {
        PageSearchWrapper wrapper = caculationMethodService.queryPage(pageNo, pageSize, cmNo);

        logger.debug(" startTime = {}, endTime = {}, pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{pageNo, pageSize, cmNo});
        return wrapper;
    }

    @ApiOperation(value = "新增计费方式")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody CaculationMethodEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = caculationMethodService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改计费方式")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody CaculationMethodEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = caculationMethodService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除计费方式")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody CaculationMethodDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = caculationMethodService.deleteInfo(params.getCmNos());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam String recordId) {
        SingleQueryWrapper wrapper = caculationMethodService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }
}
