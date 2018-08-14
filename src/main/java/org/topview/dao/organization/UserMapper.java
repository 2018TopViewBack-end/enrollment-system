package org.topview.dao.organization;

import org.apache.ibatis.annotations.Param;
import org.topview.dao.BaseMapper;
import org.topview.entity.organization.po.User;
import java.util.Set;
import java.util.List;

/**
 * @author 63023
 */
public interface UserMapper extends BaseMapper<User, Integer> {

    /**
     * 用户注册
     *
     * @param user 包含该填写的所有信息
     * @return 含id的user信息
     */
    User insertUser(User user);

    /**
     * 用户登录验证
     *
     * @param username 用户名
     * @return 包含所有信息的user
     */
    User login(String username);

    /**
     * 通过userId查看用户对应的角色
     *
     * @param userId 用户id
     * @return 用户的角色
     */
    Set<String> selectRoleByUserId(Integer userId);

    /**
     * 检查输入的旧密码正确
     *
     * @param password 旧密码
     * @param id       用户id
     * @return isEqual 输入的旧密码与数据库中的一致则返回1，不一致则返回0
     */
    Integer checkOldPassword(String password, Integer id);

    /**
     * 社团修改密码
     *
     * @param password 新密码
     * @param id       社团id
     * @return 修改成功则返回1
     */
    Integer updatePassword(String password, Integer id);

    /**
     * 更新User的状态
     * @param status 状态码 0为待审核，1为可用，2为禁用
     * @param id
     * @return
     */
    Integer updateUserStatus(@Param("status") Integer status, @Param("id") Integer id);

    /**
     * 通过社团id获取所有部门的userId
     * @param organizationId 社团id
     * @return 该社团下的部门管理员 userIdList
     */
    List<Integer> selectDepartmentUserId(Integer organizationId);
}
