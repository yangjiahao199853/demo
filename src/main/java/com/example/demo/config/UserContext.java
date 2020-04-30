package com.example.demo.config;

import com.example.demo.entity.User;

/**
 * @Author YangJiaHao
 * @Date 2020/4/30 16:24
 * @Version 1.0
 **/
public class UserContext {
    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

    public static void setUser(User loginUser) {
        userHolder.set(loginUser);
    }

    public static User getUser() {
        return userHolder.get();
    }
}
