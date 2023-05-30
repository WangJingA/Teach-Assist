package com.boot.teach.web.controllers;

import com.boot.teach.common.config.captcha.CaptchaCodeConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@Api(tags = "验证码")
@RequestMapping("/captcha")
public class CaptchaController {
    @Resource
    CaptchaCodeConfig captchaCodeConfig;

    /**
     * 教师登录验证码
     * @param request
     * @param response
     */
    @ApiOperation(value = "教师登录验证码",notes = "教师登录验证码的获取")
    @ApiParam(value = "date",name = "接收日期参数作为控制变量")
    @GetMapping("teacherCaptcha/{date}")
    public void teacherCaptcha(HttpServletRequest request, HttpServletResponse response, @PathVariable("date") String date) throws IOException {
        HttpSession session = request.getSession();
        BufferedImage image = captchaCodeConfig.getImage();
        String text = captchaCodeConfig.getText();
        session.setAttribute("teacherCaptcha",text);
        CaptchaCodeConfig.output(image,response.getOutputStream());
    }

    /**
     * 管理员登录验证码
     * @param request
     * @param response
     */
    @GetMapping("managerCaptcha/{date}")
    @ApiParam(value = "date",name = "接收日期参数作为控制变量")
    @ApiOperation(value = "管理员登录验证码",notes = "管理员登录验证码的获取")
    public void managerCaptcha(HttpServletRequest request, HttpServletResponse response, @PathVariable("date") String date) throws IOException {
        HttpSession session = request.getSession();
        BufferedImage image = captchaCodeConfig.getImage();
        String text = captchaCodeConfig.getText();
        session.setAttribute("managerCaptcha",text);
        CaptchaCodeConfig.output(image,response.getOutputStream());
    }

    /**
     * 学生登录验证码
     * @param request
     * @param response
     */
    @GetMapping("studentCaptcha/{date}")
    @ApiParam(value = "date",name = "接收日期参数作为控制变量")
    @ApiOperation(value = "学生登录验证码",notes = "学生登录验证码的获取")
    public void studentCaptcha(HttpServletRequest request, HttpServletResponse response, @PathVariable("date") String date) throws IOException {
        HttpSession session = request.getSession();
        BufferedImage image = captchaCodeConfig.getImage();
        String text = captchaCodeConfig.getText();
        session.setAttribute("studentCaptcha",text);
        CaptchaCodeConfig.output(image,response.getOutputStream());
    }
}
