package com.example.demo.controller;

import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:38
 */

@ResponseBody
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserServiceImpl iEthService;

    @RequestMapping("/save")
    public String get() {
        User user = new User();
        user.setUserName("zhangsan1");
        user.setPassword("54");
        user.setEmail("1551949453@qq.cpm");
        user.setStatus("zs");
        boolean res = iEthService.insert(user);
        return res ? "success" : "fail";
    }
}


