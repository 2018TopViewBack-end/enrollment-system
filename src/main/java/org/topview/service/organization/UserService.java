package org.topview.service.organization;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 修改密码时先检查输入的旧密码是否正确
     * @param userId
     * @param oldPassword
     * @return 正确返回1，不正确则返回0
     */
    Integer checkOldPasswordService(Integer userId, String oldPassword);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     * @return 修改成功返回1，不成功则返回0
     */
    Integer updatePasswordService(Integer userId, String newPassword);
}
