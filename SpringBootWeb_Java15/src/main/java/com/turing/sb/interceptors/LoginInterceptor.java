package com.turing.sb.interceptors;

import com.turing.sb.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    //在控制器执行前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过什么来判断登录了？session
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            //没有登录
            response.sendRedirect("/");//回到登录页面
            return false;//拦截
        }else{
            return true;//放行
        }

    }
}
