package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.UserMapper;
import org.topview.service.organization.UserService;
import org.topview.util.Result;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 修改密码时先检查输入的旧密码是否正确
     * @param userId
     * @param oldPassword
     * @return 包含错误信息的Result对象
     */
    @Override
    public Result checkOldPasswordService(Integer userId, String oldPassword) {
        if (userMapper.checkOldPassword(oldPassword,userId) == 1) {
            return new Result(true,"");
        } else {
            return new Result(false,"原密码错误，请重新输入");
        }
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     * @return Result对象
     */
    @Override
    public Result updatePasswordService(Integer userId, String newPassword) {
        if (userMapper.updatePassword(newPassword,userId) == 1) {
            return new Result(true,"密码修改成功");
        } else {
            return new Result(false,"很抱歉，密码修改失败，请稍后再试");
        }
    }

}
