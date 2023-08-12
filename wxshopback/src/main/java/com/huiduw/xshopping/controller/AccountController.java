package com.huiduw.xshopping.controller;

import cn.hutool.core.util.StrUtil;
import com.huiduw.xshopping.common.Common;
import com.huiduw.xshopping.common.Result;
import com.huiduw.xshopping.common.ResultCode;
import com.huiduw.xshopping.exception.CustomException;
import com.huiduw.xshopping.model.UserInfo;
import com.huiduw.xshopping.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/10 23:14
 * 登录退出相关的控制器
 */
@RestController
public class AccountController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        if (StrUtil.isBlank(userInfo.getName()) || StrUtil.isBlank(userInfo.getPassword())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        //从数据库查询账号密码是否正确，放到session
        UserInfo login = userInfoService.login(userInfo.getName(), userInfo.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute(Common.USER_INFO, login);
        session.setMaxInactiveInterval(60 * 24);
        return Result.success(login);
    }

    /**
     * 重置密码为123456
     */
    @PostMapping("resetPassword")
    public Result<UserInfo> resetPassword(@RequestBody UserInfo userInfo){
        return Result.success(userInfoService.resetPassword(userInfo.getName()));
    }

    /**
     * 登出
     */
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request){
        request.getSession().setAttribute(Common.USER_INFO,null);
        return Result.success();
    }
}
