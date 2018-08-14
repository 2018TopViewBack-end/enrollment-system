package org.topview.service.organization;

import org.springframework.stereotype.Service;
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
}
