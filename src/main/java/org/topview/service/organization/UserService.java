package org.topview.service.organization;

import org.springframework.stereotype.Service;
import org.topview.entity.organization.po.User;
import org.topview.util.Result;

import java.util.Set;

/**
 * @author 63023
 */
@Service
public interface UserService {


    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return 返回user完整信息
     */
    User login(String username, String password);

    /**
     * 封装该用户对应的用户与角色信息
     * @param roleName 角色名
     * @param user 用户信息
     * @return 返回封装后的用户与角色信息
     */
    Result getRoleResourceByRoleName(String roleName, User user);

    /**
     * 查看用户对应的角色
     * @param userId 用户Id
     * @return 角色名
     */
    Set<String> getRoleNameByUserIdService(Integer userId);
    /**
     * 修改密码时先检查输入的旧密码是否正确
     * @param userId
     * @param oldPassword
     * @return 正确返回1，不正确则返回0
     */
    Integer checkOldPasswordService(Integer userId, String oldPassword);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     * @return 修改成功返回1，不成功则返回0
     */
    Integer updatePasswordService(Integer userId, String newPassword);

}
