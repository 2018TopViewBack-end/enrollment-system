package org.topview.service.organization.serviceImpl;

import org.springframework.stereotype.Service;
import org.topview.service.organization.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Integer checkOldPasswordService(Integer userId, String oldPassword) {
        return null;
    }

    @Override
    public Integer updatePasswordService(Integer userId, String newPassword) {
        return null;
    }
}
