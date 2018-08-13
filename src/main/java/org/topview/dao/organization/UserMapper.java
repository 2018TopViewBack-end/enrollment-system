package org.topview.dao.organization;

import org.topview.dao.BaseMapper;
import org.topview.entity.organization.User;

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
}
