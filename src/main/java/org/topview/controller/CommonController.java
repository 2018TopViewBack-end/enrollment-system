package org.topview.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.util.VerifyCodeUtils;
import org.topview.util.vcode.Captcha;
import org.topview.util.vcode.GifCaptcha;
import org.topview.util.vcode.Randoms;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 63023
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/open")
public class CommonController {

    /**
     * 获取验证码（Gif版本）
     *
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "getGifCode", method = RequestMethod.GET)
    public String  getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {

            //获得随机验证码内容
            char[] rands = Randoms.getRandomCode();

            //设置验证码
            Captcha captcha = new GifCaptcha(146, 42,Randoms.LENGTH);
            captcha.setRands(rands);

            //将验证码放入session中
            request.getSession().setAttribute(VerifyCodeUtils.V_CODE, String.valueOf(rands));

            request.setAttribute(VerifyCodeUtils.V_CODE, String.valueOf(rands));
            System.out.println("commonController:" + request.getSession());
            System.out.println("CommonController:" + request.getSession().getAttribute(VerifyCodeUtils.V_CODE));
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            /**
             * gif格式动画验证码
             * 宽，高，位数。
             */
            //输出
            ServletOutputStream out = response.getOutputStream();
            captcha.out(out);
            out.flush();

            return "abc";
        } catch (Exception e) {
            System.out.println("CommonController has an error");
            return "abcc";
        }
    }
}
