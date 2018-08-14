package org.topview.service.organization;

import org.springframework.stereotype.Service;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.util.Result;
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
     * @return 返回user完整信息
     */
    User login(String username);

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
     * @return 包含错误信息的Result对象
     */
    Result checkOldPasswordService(Integer userId, String oldPassword);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     * @return Result对象
     */
    Result updatePasswordService(Integer userId, String newPassword);


    /**
     * 更改用户的状态为指定状态
     * @param organizationStatus 包含社团管理员userId，社团Id，目标status
     * @return
     */
    Result updateUserStatusService(OrganizationStatus organizationStatus);
}
