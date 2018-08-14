package org.topview.service.organization;

import org.springframework.stereotype.Service;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.util.Result;

@Service
public interface UserService {

    /**
     * 修改密码时先检查输入的旧密码是否正确
     * @param userId
     * @param oldPassword
     * @return 包含错误信息的Result对象
     */
    Result checkOldPasswordService(Integer userId, String oldPassword);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     * @return Result对象
     */
    Result updatePasswordService(Integer userId, String newPassword);


    /**
     * 更改用户的状态为指定状态
     * @param organizationStatus 包含社团管理员userId，社团Id，目标status
     * @return
     */
    Result updateUserStatusService(OrganizationStatus organizationStatus);
}
