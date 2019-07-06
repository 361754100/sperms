package com.smart.sperms.common;

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
    public String defaultErrorHandler(HttpServletResponse response, Exception e) {
        return JsonResult.jsonError("服务器内部错误！详细信息：" + e.getMessage(), 500);
    }

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public String incorrectCredentialsExceptionHandler() {
        return JsonResult.jsonError( "认证失败，密码错误！", 401);
    }

    @ExceptionHandler(value = UnknownAccountException.class)
    public String unknownAccountExceptionHandler() {
        return JsonResult.jsonError("认证失败，账号不存在！", 401);
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public String authenticationExceptionHandler() {
        return JsonResult.jsonError("认证失败，账号信息认证错误！", 401);
    }

    @ExceptionHandler(value = GlobalException.class)
    public String GlobalExceptionHandler(GlobalException e) {
        return JsonResult.jsonError(e.getMessage());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public String httpRequestMethodNotSupportedExceptionHandler(HttpServletResponse response) {
        return JsonResult.jsonError("method方法不允许！", 405);
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
    public String noFoundPage404() {
        return JsonResult.jsonError("没有找到访问资源！", 404);
    }

    @RequestMapping(value = "/403")
    public String forbiden403() {
        return JsonResult.jsonError("没有权限访问！", 403);
    }


}
