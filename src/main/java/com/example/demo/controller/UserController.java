package com.example.demo.controller;

import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:38
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl iEthService;

    @RequestMapping("/save")
    public String get() {
        User student = new User();
        student.setName("zhangsan1");
        student.setPassword("54");
        student.setEmail("1551949453@qq.cpm");
        boolean res = iEthService.save(student);
        return res ? "success" : "fail";
    }
}


