package com.huiduw.xshopping.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.huiduw.xshopping.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/11 15:40
 * 控制器全局异常拦截
 */
@ControllerAdvice(basePackages = "com.huiduw.xshopping.controller")
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.get();

    /*统一异常处理，主要用于Exception*/
    @ExceptionHandler(Exception.class)
    @ResponseBody    //返回json串
    public Result error(HttpServletRequest request, Exception e) {
        log.error("异常信息", e);
        return Result.error();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result customError(HttpServletRequest request, CustomException e) {
        log.error("用户异常", e.getMsg());
        return Result.error(e.getCode(), e.getMsg());
    }
}
