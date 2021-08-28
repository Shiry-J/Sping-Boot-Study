package com.example.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor implements HandlerInterceptor {
    //请求进入方法前进行拦截

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //制定拦截规则，什么时候阻止通行，什么时候放行
        //当你已经登录了，可以访问管理员主页，没有登录，不能访问主页
        Object username = request.getSession().getAttribute("userSession");
        if (username == null) {
            response.sendRedirect(request.getContextPath()+"/login");
            // 拦截
            return false;
        }
        // 放行
        return  true;
    }
}
