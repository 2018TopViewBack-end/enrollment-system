package org.topview.controller.organization;

import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.organization.po.User;
import org.springframework.web.bind.annotation.*;
import org.topview.entity.organization.vo.CheckPassword;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.service.organization.UserService;
import org.topview.util.Result;
import org.topview.util.TokenManager;
import org.topview.util.VerifyCodeUtils;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 修改密码
     * @param userId
     * @param checkPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public Result updateOldPassword(@SessionAttribute Integer userId, CheckPassword checkPassword) {
        Result result = userService.checkOldPasswordService(userId,checkPassword.getOldPassword());
        if (!result.isSuccess()) {
            //如果原密码错误，直接返回错误信息
            return result;
        } else {
            //如果原密码正确，将结果更改为修改密码的结果并返回
            result = userService.updatePasswordService(userId,checkPassword.getNewPassword());
            return result;
        }
    }

    /**
     * @param user       登陆所需的信息
     * @param rememberMe 记住状态
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(User user, Boolean rememberMe) {

        try {

            System.out.println("loginning");
            //如果验证成功,则获得获取user的完整信息
            user = TokenManager.login(user, rememberMe);

            //查看该用户的角色
            Set<String> roleNames = userService.getRoleNameByUserIdService(user.getId());
            Iterator iterator = roleNames.iterator();
            String roleName = "";

            //如果存在角色,则只获取第一个角色名
            if (iterator.hasNext()) {
                roleName = (String) iterator.next();
            }

            return Result.success(userService.getRoleResourceByRoleName(roleName, user));
        } catch (DisabledAccountException e) {
            return Result.fail(e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.fail("帐号或密码错误");
        }
    }
    /**
     * 注册 && 登录
     * @param vCode		验证码
     * @param user	User实体
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public Result subRegister(@RequestParam(value = "vCode", required = false) String vCode, User user){
        if(!VerifyCodeUtils.verifyCode(vCode)){
            System.out.println("/register中" + "验证码错误");
            return Result.fail("验证码不正确！");
        }

        if(userService.isUserExist(user)){
            return Result.fail("该用户名已存在!");
        }
        System.out.println("password:" + user.getPassword());
        //把密码md5
        Md5Hash md5Hash2 = new Md5Hash(user.getPassword(),user.getUsername(), 2);
        System.out.println("md5 Password:" + md5Hash2.toString());
        //设置有效
        user.setStatus(User.NORMAL);
        user.setPassword(md5Hash2.toString());
        return userService.register(user);
//        user = userService.insert(user);
//        LoggerUtils.fmtDebug(getClass(), "注册插入完毕！", JSONObject.fromObject(user).toString());
//        user = TokenManager.login(user, Boolean.TRUE);
//        LoggerUtils.fmtDebug(getClass(), "注册后，登录完毕！", JSONObject.fromObject(user).toString());
//        resultMap.put("message", "注册成功！");
//        resultMap.put("status", 200);
//        return resultMap;
    }

    /**
     *  修改账号的状态（用于审核新增的社团管理员，将社团管理员设置为不可用等,同时其下的部门管理员也一起设置为不可用）
     * @param organizationStatus
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserStatus")
    public Result updateUserStatus(OrganizationStatus organizationStatus) {
        return userService.updateUserStatusService(organizationStatus);

    }

//    @ResponseBody
//    @RequestMapping(value = "/register")
//    public Result register(User user) {
//        return userService.register(user);
//    }
}
