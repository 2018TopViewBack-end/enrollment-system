package org.topview.controller.organization;

import org.apache.shiro.authc.DisabledAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.organization.po.User;
import org.topview.service.organization.UserService;
import org.topview.util.Result;
import org.topview.util.TokenManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/checkOldPassword")
    public Result checkOldPassword() {
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(User user, Boolean rememberMe, HttpServletRequest request) {

        try {

            user = TokenManager.login(user, rememberMe);

            //查看该用户的角色
            Set<String> roleNames = userService.getRoleNameByUserIdService(user.getId());
            Iterator iterator = roleNames.iterator();
            String roleName = "";

            //如果存在角色,则只获取第一个角色名
            if(iterator.hasNext()) {
                roleName = (String) iterator.next();
            }

            return Result.success(userService.getRoleResourceByRoleName(roleName,user));
        } catch (DisabledAccountException e) {
            return Result.fail(e.getLocalizedMessage());
        } catch (Exception e) {
            return Result.fail("帐号或密码错误");
        }
    }
}
