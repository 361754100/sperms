package com.smart.sperms.controller;

import com.smart.sperms.request.UsersDelReq;
import com.smart.sperms.request.UsersEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Descript 用户管理控制类
 * @Version 1.0
 */
@Api(tags = "users", description = "用户管理")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

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
        PageSearchWrapper wrapper = userService.queryPage(pageNo, pageSize, startTime, endTime, keywords);

        logger.debug(" startTime = {}, endTime = {}, pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{startTime, endTime, pageNo, pageSize, keywords});
        return wrapper;
    }

    @ApiOperation(value = "新增用户信息")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody UsersEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = userService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改用户信息")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody UsersEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = userService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除用户信息")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody UsersDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = userService.deleteInfo(params.getuIds());
        return wrapper;
    }

    @ApiOperation(value = "修改密码", notes = "需登录用户后方可调用")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户账号ID", name = "uId", required = true, paramType = "form"),
            @ApiImplicitParam(value = "原密码", name = "oldPassword", required = true, paramType = "form"),
            @ApiImplicitParam(value = "新密码", name = "newPassword", required = true, paramType = "form")
    })

    @PostMapping(value = "/change_password")
    public CommonWrapper changePassword(String uId, String oldPassword, String newPassword) {
        return userService.changePassword(uId, oldPassword, newPassword);
    }

    @ApiOperation(value = "重置密码", notes = "批量重置密码为123456，传值为ID集合")
    @ApiImplicitParam(name = "ids", value = "重置密码用户ID集合，多个用户ID用,分开，如1,2,3,...", required = true, paramType = "form")
    @PostMapping(value = "reset_password")
    public CommonWrapper resetPassword(@RequestParam List<String> ids) {
        return userService.resetPassword(ids);
    }
}
