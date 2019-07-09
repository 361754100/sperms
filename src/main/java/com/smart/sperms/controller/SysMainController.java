package com.smart.sperms.controller;

import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.response.CommonWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript 系统管理控制类
 * @Version 1.0
 */
@Api(tags = "sys-main", description = "系统管理（登录、注销）")
@RestController
public class SysMainController {

    private static final Logger logger = LoggerFactory.getLogger(SysMainController.class);

    /**
     * 登录操作
     * @return

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "登录账号", required = true, paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form")
    })
    @PostMapping(value = "/login")
    public String login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password) {
        //获取shiro认证主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录认证
        subject.login(token);
        //如果认证成功
        if (subject.isAuthenticated()) {
            //获取登录信息
            Users sysUser = (Users) subject.getSession().getAttribute("loginUserInfo");
            if (sysUser == null) {
                return JsonResult.jsonError("用户信息已过期，请重新登录！");
            }
            Serializable sessionId = subject.getSession().getId();
            return PageJsonResult.getLoginUserData(username, sysUser.getuName(), sysUser.getRoleId(), sessionId, "登录成功！");
        }
        return JsonResult.jsonError("认证失败！", 401);
    }
     */

    /**
     * 退出登录
     * @return

    @ApiOperation(value = "退出登录")
    @PostMapping(value = "/loginout")
    public String logout() {
        //获取shiro认证主体
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().removeAttribute("loginUserInfo");
        subject.logout();
        return JsonResult.jsonSuccess("退出成功！");
    }
     */

    /**
     * 保持会话存活
     * @return

    @ApiOperation(value = "保存会话存活")
    @PostMapping(value = "/keepalive")
    public String keepAlive() {
        boolean isAlive = true;
        //获取shiro认证主体
        Subject subject = SecurityUtils.getSubject();
        isAlive = subject.getSession().getAttribute("loginUserInfo") != null;
        // 如果会话还活着，则更新会话状态
        if(isAlive) {
            SecurityUtils.getSubject().getSession().touch();
        }
        return JsonResult.jsonSuccess(isAlive == true ? "session alive" : "session timeout");
    }
     */


    /**
     * 账号密码校验
     * @return
     */
    @ApiOperation(value = "账号校验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "登录账号", required = true, paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form")
    })
    @PostMapping(value = "/auth")
    public CommonWrapper auth(@RequestParam(value = "username", required = true) String username,
                                        @RequestParam(value = "password", required = true) String password) {
        CommonWrapper wrapper = new CommonWrapper();
        //获取shiro认证主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录认证
        subject.login(token);
        //如果认证成功
        if (subject.isAuthenticated()) {
            wrapper.setResultMsg("鉴权成功");
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            return wrapper;
        }
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        wrapper.setResultMsg("认证失败");

        return wrapper;
    }

}
