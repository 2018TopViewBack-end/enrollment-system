package org.topview.dao.organization;

import org.topview.dao.BaseMapper;
import org.topview.entity.organization.bo.DepartmentAdminBo;
import org.topview.entity.organization.po.User;

public interface UserMapper extends BaseMapper<User, Integer> {

    /**
     * 检查输入的旧密码正确
     * @param password 旧密码
     * @param id 用户id
     * @return isEqual 输入的旧密码与数据库中的一致则返回1，不一致则返回0
     */
    Integer checkOldPassword(String password, Integer id);

    /**
     * 社团修改密码
     * @param Password 新密码
     * @param id 社团id
     * @return 修改成功则返回1
     */
    Integer updatePassword(String Password, Integer id);

    /**
     * 判断是否存在该username
     * @param username 用户名
     * @return 有返回1,否则返回0
     */
    int hasUsername(String username);

    /**
     * 添加部门管理员
     * @param departmentAdminBo 部门管理员对象
     * @return 添加成功返回1,否则返回0
     */
    int addDepartmentAdmin(DepartmentAdminBo departmentAdminBo);

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
}
