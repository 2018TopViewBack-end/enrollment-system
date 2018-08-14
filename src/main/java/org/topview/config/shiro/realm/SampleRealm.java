package org.topview.config.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.topview.entity.ShiroToken;
import org.topview.entity.organization.po.User;
import org.topview.service.organization.UserService;
import org.topview.util.TokenManager;

import java.util.Date;
import java.util.Set;

/**
 * @author 63023
 * shiro 认证 + 授权
 */
public class SampleRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    public SampleRealm() {
        super();
    }

    /**
     * 认证信息，主要针对用户登录，
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {

        ShiroToken token = (ShiroToken) authcToken;
        User user = userService.login(token.getUsername(), token.getPswd());
        if (null == user) {
            throw new AccountException("帐号或密码不正确！");
            /**
             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
             */
        } else if (User.FORBID.equals(user.getStatus())) {
            throw new DisabledAccountException("帐号已经禁止登录！");
        } else if (User.CHECKING.equals(user.getStatus())){
            throw new DisabledAccountException("帐号正在审核中！");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        User user = TokenManager.getToken();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        Set<String> roleName = userService.getRoleNameByUserIdService(user.getId());
        System.out.println("role:" + roleName);
        info.setRoles(roleName);
        return info;
    }

    /**
     * 清空当前用户权限信息
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 指定principalCollection 清除
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
