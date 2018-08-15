package org.topview.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.organization.po.User;
import org.topview.util.TokenManager;
import org.topview.util.VerifyCodeUtils;
import org.topview.util.vcode.Captcha;
import org.topview.util.vcode.GifCaptcha;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 63023
 */
@Controller
@Scope(value="prototype")
@RequestMapping("/open")
public class CommonController {
    /**
     * 获取验证码（Gif版本）
     * @param response
     */
    @RequestMapping(value="getGifCode",method=RequestMethod.GET)
    public void getGifCode(HttpServletResponse response, HttpServletRequest request){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /**
             * gif格式动画验证码
             * 宽，高，位数。
             */
            Captcha captcha = new GifCaptcha(146,42,4);
            //输出
            ServletOutputStream out = response.getOutputStream();
            captcha.out(out);
            out.flush();
            //存入Shiro会话session
            System.out.println( "captcha.text: " + captcha.text().toLowerCase());
            TokenManager.setVal2Session(VerifyCodeUtils.V_CODE, captcha.text().toLowerCase());
        } catch (Exception e) {
//            LoggerUtils.fmtError(getClass(),e, "获取验证码异常：%s",e.getMessage());
        }
    }


    /**
     * 获取验证码
     * @param response
     */
    @RequestMapping(value="getVCode",method=RequestMethod.GET)
    public void getVCode(HttpServletResponse response,HttpServletRequest request){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpg");

            System.out.println("get vcode1");
            //生成随机字串
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            //存入Shiro会话session
            TokenManager.setVal2Session(VerifyCodeUtils.V_CODE, verifyCode.toLowerCase());
            //生成图片
            int w = 146, h = 33;
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

            System.out.println("get vcode2");
        } catch (Exception e) {
//            LoggerUtils.fmtError(getClass(),e, "获取验证码异常：%s",e.getMessage());
        }
    }
}
