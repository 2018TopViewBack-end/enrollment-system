package org.topview.dao.organization;

import org.topview.dao.BaseMapper;
import org.topview.entity.organization.po.User;

/**
 * @author 63023
 */
public interface UserMapper extends BaseMapper<User, Integer> {

    /**
     *用户注册
     * @param user 包含该填写的所有信息
     * @return 含id的user信息
     */
    User insertUser(User user);

    /**
     *用户登录验证
     * @param user 包含用户名和密码
     * @return 包含所有信息的user
     */
    User selectUserByUsername(User user);
}
