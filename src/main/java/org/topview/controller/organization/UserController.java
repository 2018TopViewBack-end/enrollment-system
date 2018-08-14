package org.topview.controller.organization;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.topview.entity.organization.vo.CheckPassword;
import org.topview.service.organization.UserService;
import org.topview.util.Result;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public Result checkOldPassword(@SessionAttribute Integer userId, CheckPassword checkPassword) {
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
}
