package com.smart.sperms.controller;

import com.smart.sperms.request.*;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import com.smart.sperms.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "sysrole", description = "角色信息")
@RestController
@RequestMapping(value = "sysrole")
public class SysRoleController {

    private static Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

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
        PageSearchWrapper wrapper = sysRoleService.queryPage(pageNo, pageSize, startTime, endTime, keywords);

        logger.debug(" startTime = {}, endTime = {}, pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{startTime, endTime, pageNo, pageSize, keywords});
        return wrapper;
    }

    @ApiOperation(value = "新增角色信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody SysRoleAddReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = sysRoleService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改角色信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody SysRoleEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = sysRoleService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除角色信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody SysRoleDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = sysRoleService.deleteInfo(params.getRoleIds());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "int")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam int recordId) {
        SingleQueryWrapper wrapper = sysRoleService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }

    @ApiOperation(value = "角色关联菜单")
    @PostMapping(value = "/add_menu_relation")
    public CommonWrapper addMenuRelation(@RequestBody SysRoleAddMenuRelationReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = sysRoleService.addRoleMenuRelation(params);
        return wrapper;
    }

    @ApiOperation(value = "根据角色ID和菜单ID删除关联关系")
    @PostMapping(value = "/del_relation_by_role_menu_ids")
    public CommonWrapper delRelationByRoleMenuIds(@RequestBody SysRoleDelMenuRelationReq params) {
        logger.debug(" params = {}", params);
        CommonWrapper wrapper = sysRoleService.delRelationByRoleMenuId(params.getRoleId(), params.getMenuIds());
        return wrapper;
    }

    @ApiOperation(value = "根据角色ID删除关联关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name="roleIds", value = "角色ID（多个ID用逗号隔开：1,2,3）", required = true, paramType = "form", dataType = "int")
    })
    @PostMapping(value = "/del_relation_by_role_ids")
    public CommonWrapper delRelationByRoleIds(@RequestParam List<Integer> roleIds) {
        logger.debug(" roleIds = {}", new Object[]{roleIds});
        CommonWrapper wrapper = sysRoleService.delRelationByRoleIds(roleIds);
        return wrapper;
    }
}
