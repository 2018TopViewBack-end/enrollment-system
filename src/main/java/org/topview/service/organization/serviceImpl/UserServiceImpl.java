package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.UserMapper;
import org.topview.service.organization.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 修改密码时先检查输入的旧密码是否正确
     * @param userId
     * @param oldPassword
     * @return 正确返回1，不正确则返回0
     */
    @Override
    public Integer checkOldPasswordService(Integer userId, String oldPassword) {
        return userMapper.checkOldPassword(oldPassword,userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     * @return 修改成功返回1，不成功则返回0
     */
    @Override
    public Integer updatePasswordService(Integer userId, String newPassword) {
        return userMapper.updatePassword(newPassword,userId);
    }
}
