package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.UserMapper;
import org.topview.entity.organization.po.User;
import org.topview.service.organization.OrganizationService;
import org.topview.service.organization.UserService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 63023
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrganizationService organizationService;

    @Override
    public User login(String username) {
        return userMapper.login(username);
    }

    @Override
    public Set<String> getRoleNameByUserIdService(Integer userId) {
        return userMapper.selectRoleByUserId(userId);
    }

    @Override
    public Result getRoleResourceByRoleName(String roleName,User user) {

        if (roleName == null || "".equals(roleName)) {
            return Result.fail("无对应的角色信息");
        }

        Map<String, Object> map = new HashMap<>(10);

        //将密码私密化
        user.setPassword(null);

        //存储user信息
        map.put("user", user);

        //根据用户对应角色给予其对应的数据
        switch (roleName) {
            case Constant.ORGANIZATION:
                //存储社团信息
                map.put(Constant.ORGANIZATION, organizationService.getOrganizationIdByAdminId(user.getId()));
                break;
            case Constant.DEPARTMENT:
                //存储部门信息
                map.put(Constant.DEPARTMENT, null);
                break;
            case Constant.ADMIN:
                //存储超级管理员信息
                map.put(Constant.ADMIN, null);
                break;
            default:

        }

        return Result.success(map);
    }
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
