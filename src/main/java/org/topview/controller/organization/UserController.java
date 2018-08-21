package org.topview.controller.organization;

import org.apache.shiro.authc.DisabledAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.topview.config.exception.RegisterFailException;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.CheckPassword;

import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.entity.organization.vo.OrganizationVo;
import org.topview.service.organization.UserService;
import org.topview.util.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Set;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 修改密码
     * @param user 用户在登录后session中存放着一个user对象
     * @param checkPassword 修改密码的vo类对象，包含用户输入的原密码和新密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public Result updateOldPassword(@SessionAttribute User user, @RequestBody CheckPassword checkPassword) {
        if (userService.checkOldPasswordService(user.getUsername(),checkPassword.getOldPassword())) {
            //如果原密码正确，将结果更改为修改密码的结果并返回
            if(userService.updatePasswordService(user.getUsername(),checkPassword.getNewPassword())) {
                return Result.success();
            } else {
                return Result.fail("很抱歉，密码修改失败，请稍后再试");
            }
        } else {
            //如果原密码错误，直接返回错误信息
            return Result.fail("原密码错误，请重新输入");
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

            return userService.getRoleResourceByRoleName(roleName, user);
        } catch (DisabledAccountException e) {
            return Result.fail(e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.fail("帐号或密码错误");
        }
    }

    /**
     * 注册 && 登录*
     * @param organizationVo 社团VO对象
     * @param request  httpRequest
     * @return Result
     */
    @ResponseBody
    @RequestMapping(value = "/register")
    public Result subRegister(@RequestBody OrganizationVo organizationVo, HttpServletRequest request) {
        try {
            User user = organizationVo.getUser();
            String vCode = organizationVo.getvCode();

            //如果该角色不为社团管理员,则启用验证码登录
            if (user.getRoleId() != Constant.Role.ORGANIZATION_ADMIN) {

                System.out.println("userControllerSession:" + request.getSession());
                String rightVcode = (String) request.getSession().getAttribute(VerifyCodeUtils.V_CODE);
                request.getSession().removeAttribute(VerifyCodeUtils.V_CODE);
                System.out.println("vCode:" + vCode);
                System.out.println("rightVcode:" + rightVcode);
                if (!rightVcode.equalsIgnoreCase(vCode)) {
                    return Result.fail("验证码不正确！");
                }
            }

            if (userService.isUserExist(user)) {
                return Result.fail("该用户名已存在!");
            }

            //MD5加密
            organizationVo.getUser().setPassword(Md5Util.getMD5Password(user.getUsername(), user.getPassword()));
            //设置有效
            user.setStatus(User.NORMAL);

            return userService.register(user, organizationVo.getOrganization());
        }
//    catch (RegisterFailException e){
//        return Result.fail(e.getLocalizedMessage());
//    }
        catch (RegisterFailException e) {
            return Result.fail(e.getLocalizedMessage());
        } catch (Exception e) {
            return Result.fail(e.getLocalizedMessage());
        }

    }

    /**
     * 修改账号的状态（用于审核新增的社团管理员，将社团管理员设置为不可用等,同时其下的部门管理员也一起设置为不可用）
     * @param organizationStatus
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserStatus",method = RequestMethod.POST)
    public Result updateUserStatus(@RequestBody OrganizationStatus organizationStatus){
        try {
            userService.updateUserStatusService(organizationStatus);
            return Result.success();
        } catch (Exception e) {
            return Result.fail("很抱歉，修改失败，请稍后再试");
        }
    }

    /**
     * 通过待审核社团，并向社团表中添加该社团发短信使用的apiKey
     * @param organizationStatus 包含社团管理员userId，社团Id，目标status
     * @param apiKey 发短信使用的apiKey
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserStatus/{apiKey}", method = RequestMethod.POST)
    public Result acceptOrganization(@RequestBody OrganizationStatus organizationStatus, @PathVariable String apiKey) {
        try {
            userService.updateUserStatusService(organizationStatus,apiKey);
            return Result.success();
        } catch (Exception e) {
            return Result.fail("通过失败，请稍后再试");
        }
    }

//    @ResponseBody
//    @RequestMapping(value = "/register")
//    public Result register(User user) {
//        return userService.register(user);
//    }
}
