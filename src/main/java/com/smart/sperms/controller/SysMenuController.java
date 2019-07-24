package com.smart.sperms.controller;

import com.smart.sperms.request.SysMenuAddReq;
import com.smart.sperms.request.SysMenuDelReq;
import com.smart.sperms.request.SysMenuEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.ListQueryWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "sysmenu", description = "菜单信息")
@RestController
@RequestMapping(value = "sysmenu")
public class SysMenuController {

    private static Logger logger = LoggerFactory.getLogger(SysMenuController.class);

    @Autowired
    private SysMenuService sysMenuService;

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
        PageSearchWrapper wrapper = sysMenuService.queryPage(pageNo, pageSize, startTime, endTime, keywords);

        logger.debug(" startTime = {}, endTime = {}, pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{startTime, endTime, pageNo, pageSize, keywords});
        return wrapper;
    }

    @ApiOperation(value = "新增菜单信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody SysMenuAddReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = sysMenuService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改菜单信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody SysMenuEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = sysMenuService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除菜单信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody SysMenuDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = sysMenuService.deleteInfo(params.getMenuIds());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "int")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam int recordId) {
        SingleQueryWrapper wrapper = sysMenuService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }

    @ApiOperation(value = "按角色ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="roleId", value = "角色ID", required = true, paramType = "form", dataType = "int")
    })
    @PostMapping(value = "/find_by_roleid")
    public ListQueryWrapper findMenusByRoleId(@RequestParam int roleId) {
        ListQueryWrapper wrapper = sysMenuService.findMenusByRoleId(roleId);

        logger.debug(" roleId = {}",
                new Object[]{roleId});
        return wrapper;
    }
}
