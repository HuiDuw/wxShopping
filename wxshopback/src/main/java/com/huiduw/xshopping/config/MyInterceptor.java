package com.huiduw.xshopping.config;

import com.huiduw.xshopping.common.Common;
import com.huiduw.xshopping.model.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/18 17:12
 * 如果未登录，重定向到登录页
 * 全局拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 所有访问后台的请求先要从这里路过
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     * 返回true执行后面的请求，返回false中断后面的请求，重定向到登录页
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(Common.USER_INFO);
        if(userInfo == null){
            HttpSession session = request.getSession();
            session.setAttribute("notificationMessage","无操作权限");
            //重定向到登录页
            response.sendRedirect("/end/page/login.html");
            ServletContext context = request.getServletContext();
            context.log("无权限访问");
            return false;
        }
        return true;
    }
}
