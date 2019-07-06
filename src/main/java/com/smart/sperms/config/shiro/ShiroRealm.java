package com.smart.sperms.config.shiro;

import com.smart.sperms.dao.mapper.UsersMapper;
import com.smart.sperms.dao.model.Users;
import com.smart.sperms.utils.EncryptUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 自定义Realm
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UsersMapper usersMapper;

//    @Value("${system.version}")
    private String systemVersion = "";

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //从主体传过来认证信息中，获取用户名
        String userid = (String) authenticationToken.getPrincipal();
        //获取主体密码
        String password = new String((char[]) authenticationToken.getCredentials());
        String MD5Pwd = EncryptUtils.encryptPasswordByPassword(password);

        //通过用户名到数据库中获取凭证
        Users sysUser = usersMapper.selectByPrimaryKey(userid);
        if (sysUser == null) {
            throw new UnknownAccountException("账号不存在");
        }
        if (sysUser!=null && !MD5Pwd.equals(sysUser.getuPassword())) {
            throw new IncorrectCredentialsException("密码错误");
        }

        //获取shiro认证主体
        Subject subject = SecurityUtils.getSubject();
        subject.getSession(true).setAttribute("loginUserInfo", sysUser);
        subject.getSession(true).setAttribute("systemVersion", systemVersion);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser, password, getName());

        return simpleAuthenticationInfo;
    }
}
