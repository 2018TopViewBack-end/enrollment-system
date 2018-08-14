package org.topview.controller.organization;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.topview.entity.organization.vo.CheckPassword;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.service.organization.UserService;
import org.topview.util.Result;

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
     *  修改账号的状态（用于审核新增的社团管理员，将社团管理员设置为不可用等,同时其下的部门管理员也一起设置为不可用）
     * @param organizationStatus
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserStatus")
    public Result updateUserStatus(OrganizationStatus organizationStatus) {
        return userService.updateUserStatusService(organizationStatus);
    }
}
