package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.UserMapper;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.service.organization.UserService;
import org.topview.util.Result;

import java.util.List;

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
            return Result.success();
        } else {
            return Result.fail("原密码错误，请重新输入");
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
            return Result.success();
        } else {
            return Result.fail("很抱歉，密码修改失败，请稍后再试");
        }
    }

    /**
     * 更改管理员的状态为指定状态
     * @param os 包含社团管理员userId，社团Id，目标status
     * @return
     */
    @Override
    public Result updateUserStatusService(OrganizationStatus os) {
        List<Integer> departmentUserIdList = userMapper.selectDepartmentUserId(os.getOrganizationId());
        // 如果这个社团管理员下有部门管理员，把部门管理员修改成与社团管理员一样的状态
        if (departmentUserIdList != null){
            for (Integer userId : departmentUserIdList) {
                Integer result = userMapper.updateUserStatus(os.getStatus(),userId);
                if(result != 1) {
                    return Result.fail("很抱歉，修改失败，请稍后再试");
                }
            }
        }
        if( userMapper.updateUserStatus(os.getStatus(),os.getUserId()) == 1) {
            return Result.success();
        } else {
            return Result.fail("很抱歉，修改失败，请稍后再试");
        }
    }
}
