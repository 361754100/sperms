package com.smart.sperms.common;

import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.response.CommonWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Descript 自定义全局异常处理类
 * @Author fuyuanming
 * @Date 2019-04-30 10:18:57
 * @Version 1.0
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public CommonWrapper defaultErrorHandler(HttpServletResponse response, Exception e) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        wrapper.setResultMsg("服务器内部错误！详细信息：" + e.getMessage());
        return wrapper;
    }

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public CommonWrapper incorrectCredentialsExceptionHandler() {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        wrapper.setResultMsg("认证失败，密码错误！");
        return wrapper;
    }

    @ExceptionHandler(value = UnknownAccountException.class)
    public CommonWrapper unknownAccountExceptionHandler() {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        wrapper.setResultMsg("认证失败，账号不存在！");
        return wrapper;
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public CommonWrapper authenticationExceptionHandler() {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        wrapper.setResultMsg("认证失败，账号信息认证错误！");
        return wrapper;
    }

    @ExceptionHandler(value = GlobalException.class)
    public CommonWrapper GlobalExceptionHandler(GlobalException e) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.UNKNOW.getCode());
        wrapper.setResultMsg(e.getMessage());
        return wrapper;
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public CommonWrapper httpRequestMethodNotSupportedExceptionHandler(HttpServletResponse response) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        wrapper.setResultMsg("method方法不允许！");
        return wrapper;
    }

    /**
     * 自定义http异常处理
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return (factory -> {
            ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
            factory.addErrorPages(errorPage404, errorPage403);
        });
    }

    @RequestMapping(value = "/404")
    public CommonWrapper noFoundPage404() {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.RESOURCE_NOT_FOUND.getCode());
        wrapper.setResultMsg("没有找到访问资源！");
        return wrapper;
    }

    @RequestMapping(value = "/403")
    public CommonWrapper forbiden403() {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FORBIDDEN.getCode());
        wrapper.setResultMsg("没有权限访问！");
        return wrapper;
    }


}
