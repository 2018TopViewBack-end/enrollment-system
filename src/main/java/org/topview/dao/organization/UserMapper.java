package org.topview.dao.organization;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.topview.dao.BaseMapper;
import org.topview.entity.organization.bo.DepartmentAdminBo;
import org.topview.entity.organization.po.User;
import java.util.Set;
import java.util.List;

/**
 * @author 63023
 */
@Repository
public interface UserMapper extends BaseMapper<User, Integer> {

    /**
     * 用户注册
     *
     * @param user 包含该填写的所有信息
     * @return 含id的user信息
     */
    Integer insertUser(User user);

    /**
     * 用户登录验证
     *
     * @param username 用户名
     * @return 包含所有信息的user
     */
    User selectUserByUsername(String username);

    /**
     * 通过userId查看用户对应的角色
     *
     * @param userId 用户id
     * @return 用户的角色
     */
    Set<String> selectRoleByUserId(Integer userId);

    /**
     * 检查输入的旧密码正确
     * @param password 旧密码
     * @param username 用户名
     * @return isEqual 输入的旧密码与数据库中的一致则返回1，不一致则返回0
     */
    Integer checkOldPassword(@Param("password") String password, @Param("username") String username);

    /**
     * 社团修改密码
     * @param password 新密码
     * @param username 用户名
     * @return 修改成功则返回1
     */
    Integer updatePassword(@Param("password") String password, @Param("username") String username);

    /**
     * 批量更新User的状态
     * @param status 状态码 0为待审核，1为可用，2为禁用
     * @param idList
     * @return
     */
    Integer updateUserStatus1(@Param("status") Integer status, @Param("idList") List<Integer> idList);

    /**
     * 更新User的状态
     * @param status 状态码 0为待审核，1为可用，2为禁用
     * @param id
     * @return
     */
    Integer updateUserStatus2(@Param("status") Integer status, @Param("id") Integer id);

    /**
     * 判断是否存在该username
     * @param username 用户名
     * @return 有返回1,否则返回0
     */
    int hasUsername(String username);

    /**
     * 获取部门管理员的信息
     * @param departmentId 部门id
     * @return 查询到返回对应的user对象，否则返回null
     */
    User getDepartmentAdmin(Integer departmentId);

    /**
     * 修改部门管理员的信息
     * @param user 部门管理员对象
     * @return 修改成功返回1,否则返回0
     */
    int updateDepartmentAdmin(User user);

    /**
     * 删除部门管理员的信息
     * @param departmentId 部门id
     * @return 删除成功返回1,否则返回0
     */
    int deleteDepartmentAdmin(Integer departmentId);

    /**
     * 通过社团id获取所有部门的userId
     * @param organizationId 社团id
     * @return 该社团下的部门管理员 userIdList
     */
    List<Integer> selectDepartmentUserId(Integer organizationId);

    /**
     * 通过userId获得user
     * @param userId
     * @return
     */
    @Override
    User selectByPrimaryKey(Integer userId);

}
