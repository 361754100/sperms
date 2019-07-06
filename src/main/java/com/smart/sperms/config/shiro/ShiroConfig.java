package com.smart.sperms.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Descript shiro配置类
 * @Author fuyuanming
 * @Date 2018-07-05 17:29:57
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {

    /**
     * 注册自定义Realm
     * @return
     */
    @Bean
    public ShiroRealm customRealm() {
        return new ShiroRealm();
    }

    /**
     * 注册shiro安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置Realm
        securityManager.setRealm(customRealm());
        //设置session管理器
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    /**
     * 注册shiro安全过滤器
     * @param securityManager 安全管理器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/home");
        return shiroFilterFactoryBean;
    }

    /**
     * 注册session管理器
     * @return
     */
    @Bean
    public SessionManager sessionManager(SessionDAO sessionDAO, SimpleCookie simpleCookie) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        //清除无效的session
        sessionManager.setDeleteInvalidSessions(true);
        //设置session过期时间（30分钟）
        sessionManager.setGlobalSessionTimeout(1800000);
        //设置sessionDAO
        sessionManager.setSessionDAO(sessionDAO);
        //cookie管理
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(simpleCookie);
        return sessionManager;
    }

    /**
     * 注册sessionDAO
     * @return
     */
    @Bean
    public SessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        //uuid生成
        sessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());
        return sessionDAO;
    }

    /**
     * 注册cookie管理
     * @return
     */
    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("mldn-session-id");
        simpleCookie.setHttpOnly(true);
        //cookie过期时间，-1表示关闭浏览器cookie失效
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }

}
