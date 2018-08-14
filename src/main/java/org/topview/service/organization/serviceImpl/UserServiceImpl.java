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
    UserMapper userMapper;
    @Autowired
    OrganizationService organizationService;
    @Override
    public Integer checkOldPasswordService(Integer userId, String oldPassword) {
        return null;
    }

    @Override
    public Integer updatePasswordService(Integer userId, String newPassword) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
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
}
