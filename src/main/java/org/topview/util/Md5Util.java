package org.topview.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.topview.entity.organization.po.User;

/**
 * 该工具类用于md5加密
 * @author 63023
 */
public class Md5Util {

    /**
     * 获得加密后的密码
     * @param username 用户名
     * @param password 密码
     * @return 加密后的密码
     */
    public static String getMD5Password(String username, String password) {

        Md5Hash md5Hash = new Md5Hash(password, username, 2);
        return md5Hash.toString();
    }

}
