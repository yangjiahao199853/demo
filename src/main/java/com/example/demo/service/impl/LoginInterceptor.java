package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * @Author YangJiaHao
 * @Date 2020/4/30 16:25
 * @Version 1.0
 **/
@Service
public class LoginInterceptor extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            User loginUser = getUser(request, response);
//            UserContext.setUser(loginUser);
//        }
//        return super.preHandle(request, response, handler);
//    }
//
//    private User getUser(HttpServletRequest request, HttpServletResponse response) {
//        String token = request.getParameter("token");
//        // 然后根据token获取用户登录信息，这里省略获取用户信息的过程
//        User loginUser = new User();
//        loginUser.setId(1L);
//        loginUser.setUserName("lizhencheng");
//
//        // 如果这里校验用户信息失败，则直接抛出异常
//
//        return loginUser;
//    }
}
