package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.topview.config.exception.RegisterFailException;
import org.topview.dao.department.DepartmentMapper;
import org.topview.dao.department.StageMapper;

import org.springframework.transaction.annotation.Propagation;

import org.topview.dao.organization.OrganizationMapper;
import org.topview.dao.organization.UserMapper;
import org.topview.entity.department.vo.DepartmentVo;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.service.organization.OrganizationService;
import org.topview.service.organization.UserService;
import org.topview.util.Constant;
import org.topview.util.Md5Util;
import org.topview.util.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 63023
 */


@Service
public class UserServiceImpl implements UserService {

    private static final String USERNAME_ALREADY_EXIST = "用户名已存在";
    private static final String USERNAME_NOT_BE_EMPTY = "用户名不能为空";
    private static final String PASSWORD_NOT_BE_EMPTY = "密码不能为空";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private StageMapper stageMapper;
    @Autowired
    private OrganizationService organizationService;


    @Override
    public User login(String username) {
        return userMapper.selectUserByUsername(username);

    }

    @Override
    public Boolean isUserExist(User user) {
        return userMapper.selectUserByUsername(user.getUsername()) != null;

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result register(User user, Organization organization) throws RegisterFailException {

        //对用户名进行判断
        String username = user.getUsername();
        if (username == null || "".equals(username)) {
            return Result.fail(USERNAME_NOT_BE_EMPTY);
        }
        if (null != userMapper.selectUserByUsername(user.getUsername())) {
            return Result.fail("用户名已存在");
        }

        //包装注册用户的信息
        user.setRoleId(Constant.Role.ORGANIZATION_ADMIN);
        user.setStatus(User.NORMAL);

        Integer insertUserNum = userMapper.insertUser(user);
        Integer insertOrganizationNum = organizationMapper.insert(organization);


        //添加
        if (insertUserNum == 1 && insertOrganizationNum == 1) {
            Map<String, Object> map = new HashMap<>(2);
            map.put("user", user);
            map.put("organization", organization);
            return Result.success(map);
        } else {
            throw new RegisterFailException();
        }


    }

    @Override
    public Set<String> getRoleNameByUserIdService(Integer userId) {
        return userMapper.selectRoleByUserId(userId);
    }

    @Override
    public Result getRoleResourceByRoleName(String roleName, User user) {

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
                map.put(Constant.ORGANIZATION, organizationMapper.getOrganizationIdByAdminId(user.getId()));
                //存储社团首页URL
                map.put("url", "/organization/ ");
                break;
            case Constant.DEPARTMENT:
                //存储部门信息
                DepartmentVo departmentVo = departmentMapper.getDepartmentByUserId(user.getId());
                map.put(Constant.DEPARTMENT, departmentVo);
                map.put("stage", stageMapper.selectByExample(departmentVo.getId()));
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
     * @param username
     * @param oldPassword
     * @return 包含错误信息的Result对象
     */
    @Override
    public boolean checkOldPasswordService(String username, String oldPassword) {
        //将用户输入的旧密码加密后再跟数据库的进行比对
        oldPassword = Md5Util.getMD5Password(username,oldPassword);
        return userMapper.checkOldPassword(oldPassword,username) == 1 ;
    }

    /**
     * 修改密码
     * @param username
     * @param newPassword
     * @return Result对象
     */
    @Override
    public boolean updatePasswordService(String username, String newPassword) {
        //将用户输入的新密码加密后传入数据库
        newPassword = Md5Util.getMD5Password(username,newPassword);
        return userMapper.updatePassword(newPassword,username) == 1;
    }

    /**
     * 更改管理员的状态为指定状态
     *
     * @param os 包含社团管理员userId，社团Id，目标status
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateUserStatusService(OrganizationStatus os) throws Exception{
        List<Integer> departmentUserIdList = userMapper.selectDepartmentUserId(os.getOrganizationId());
        // 如果这个社团管理员下有部门管理员，把部门管理员修改成与社团管理员一样的状态
        if (departmentUserIdList.size() != 0) {
                Integer result = userMapper.updateUserStatus1(os.getStatus(),departmentUserIdList);
                if(result != departmentUserIdList.size()) {
                    throw new Exception();
                }
        }
        if(userMapper.updateUserStatus2(os.getStatus(),os.getUserId()) == 1) {
            return true;
        } else {
            throw new Exception();
        }
    }

    /**
     * 通过待审核社团
     * @param os 包含社团管理员userId，社团Id，目标status
     * @param apiKey 社团发送短信的apiKey
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateUserStatusService(OrganizationStatus os, String apiKey) throws Exception {
        if(userMapper.updateUserStatus2(os.getStatus(),os.getUserId()) == 1
                && organizationMapper.addApiKey(apiKey,os.getOrganizationId()) == 1) {
            return true;
        } else {
            throw new Exception();
        }
    }
}
