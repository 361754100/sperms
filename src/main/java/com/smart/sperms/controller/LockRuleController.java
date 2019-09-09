package com.smart.sperms.controller;

import com.smart.sperms.request.LockRuleDelReq;
import com.smart.sperms.request.LockRuleEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.LockRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "lockrule", description = "停机/锁机策略")
@RestController
@RequestMapping(value = "lockrule")
public class LockRuleController {

    private static Logger logger = LoggerFactory.getLogger(LockRuleController.class);

    @Autowired
    private LockRuleService lockRuleService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="keywords", value = "关键字", paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam(required = false) String keywords) {
        PageSearchWrapper wrapper = lockRuleService.queryPage(pageNo, pageSize, keywords);

        logger.debug(" pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{pageNo, pageSize, keywords});
        return wrapper;
    }

    @ApiOperation(value = "新增策略信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody LockRuleEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = lockRuleService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改策略信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody LockRuleEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = lockRuleService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除策略信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody LockRuleDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = lockRuleService.deleteInfo(params.getLrNos());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam String recordId) {
        SingleQueryWrapper wrapper = lockRuleService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }
}
