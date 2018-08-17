package org.topview.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.topview.entity.ShiroToken;
import org.topview.entity.organization.po.User;

import java.util.Collection;
import java.util.List;

/**
 * @author 63023
 * Shiro管理下的Token工具类
 */
public class TokenManager {

    /**
     * 获取当前登录的用户User对象
     *
     * @return
     */
    public static User getToken() {
        User token = (User) SecurityUtils.getSubject().getPrincipal();
        return token;
    }


    /**
     * 获取当前用户的Session
     *
     * @return
     */
    public static Session getSession() {
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println("session" + session);
        return session;
    }

    /**
     * 获取当前用户NAME
     *
     * @return
     */
    public static String getNickname() {
        return getToken().getUsername();
    }

    /**
     * 获取当前用户ID
     *
     * @return
     */
    public static Integer getUserId() {
        return getToken() == null ? null : getToken().getId();
    }

    /**
     * 把值放入到当前登录用户的Session里
     *
     * @param key
     * @param value
     */
    public static void setVal2Session(Object key, Object value) {

//        System.out.println("TokenManager中setVal2Session的key:" + key);
//        System.out.println("TokenManager中setVal2Session的value:" + value);
        System.out.println("setVal2Session ...");
        getSession().setAttribute(key, value);

//        System.out.println("TokenManager.setVal2Session:" + getSession().getAttribute(key));

    }


    /**
     * 获取验证码，获取一次后删除
     *
     * @return
     */
    public static String getYZM() {

        String code = (String) getSession().getAttribute(VerifyCodeUtils.V_CODE);

        System.out.println("TokenManager.getYZM:" + code);

        getSession().removeAttribute("_CODE");
        return code;
    }


    /**
     * 从当前登录用户的Session里取值
     *
     * @param key
     * @return
     */
    public static Object getVal2Session(Object key) {

        System.out.println("TokenManager中getVal2Session的key:" + key);
        System.out.println("TokenManager中getVal2Session的sessionKey:" + getSession().getAttribute(key));

        return getSession().getAttribute(key);
    }

    /**
     * 登录
     *
     * @param user
     * @param rememberMe
     * @return
     */
    public static User login(User user, Boolean rememberMe) {
        ShiroToken token = new ShiroToken(user.getUsername(), user.getPassword());
        token.setRememberMe(rememberMe);
        SecurityUtils.getSubject().login(token);
        return getToken();
    }


    /**
     * 判断是否登录
     *
     * @return
     */
    public static boolean isLogin() {
        return null != SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 退出登录
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }


}