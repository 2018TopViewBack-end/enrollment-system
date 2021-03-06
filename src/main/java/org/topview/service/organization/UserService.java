package org.topview.service.organization;

import org.springframework.stereotype.Service;
import org.topview.config.exception.RegisterFailException;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.util.Result;

import javax.naming.AuthenticationException;
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
     * 是否存在同名的user
     * @param user
     * @return
     */
    Boolean isUserExist(User user);

    /**
     * 注册
     * @param user 用戶信息
     * @param organization 社团信息
     * @return 返回带有userId的user对象
     */
    Result register(User user, Organization organization) throws RegisterFailException;

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
     * @param username
     * @param oldPassword
     * @return 包含错误信息的Result对象
     */
    boolean checkOldPasswordService(String username, String oldPassword);

    /**
     * 修改密码
     * @param username
     * @param newPassword
     * @return Result对象
     */
    boolean updatePasswordService(String username, String newPassword);


    /**
     * 更改用户的状态为指定状态
     * @param organizationStatus 包含社团管理员userId，社团Id，目标status
     * @return
     */
    boolean updateUserStatusService(OrganizationStatus organizationStatus) throws Exception;

    /**
     * 新增社团，通过审核后输入apiKey
     * @param organizationStatus 包含社团管理员userId，社团Id
     * @param apiKey 社团发送短信的apiKey
     * @return
     */
    boolean updateUserStatusService(OrganizationStatus organizationStatus, String apiKey) throws Exception;
}
