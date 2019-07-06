package com.smart.sperms.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Descript 登录日志类
 * @Date 2019-04-17 17:05:18
 * @Version 1.0
 */
@Aspect
@Component
public class LoginLogAop {

//    @Autowired
//    LoginLogServiceImpl loginLogService;

    //耗时
    public long spendTime = 0L;

    //登录方法切入
    @Pointcut("execution(public * com.smart.sperms..controller.LoginController.login(..))")
    public void loginLog() { }

    @Around("loginLog()")
    public Object loginAround(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        spendTime = System.currentTimeMillis() - start;
        return result;
    }

    /**
     * 登录后记录日志
     * @param joinPoint
     */
    @AfterReturning(value = "loginLog()", returning = "object")
    public void loginAfter(JoinPoint joinPoint, Object object) {
        //登录成功后记录日志
        if (object.toString().contains("登录成功")) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            /*SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
            SysLoginLog loginLog = new SysLoginLog();
            if (request.getHeader("User-Agent") != null) {
                UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
                //浏览器信息
                Browser browser = userAgent.getBrowser();
                loginLog.setBrowserName(browser.getName());
                loginLog.setBrowserType(browser.getBrowserType().getName());
                if ("Unknown".equals(browser.getName())) {
                    loginLog.setBrowserVersion("Unknown");
                } else {
                    loginLog.setBrowserVersion(userAgent.getBrowserVersion().getVersion());
                }
                loginLog.setOperationSystem(userAgent.getOperatingSystem().getName());
                loginLog.setUsername(user.getName());
                loginLog.setIp(IPUtils.getClinetIp(request));
                loginLog.setLoginStatus(1);
                loginLog.setSpendTime(spendTime);
                //保存登录日志
                loginLogService.addLoginLog(loginLog);
            }*/
        }
    }

}
