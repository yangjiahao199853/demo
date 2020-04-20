package com.example.demo.controller;

import com.example.demo.service.impl.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:38
 */
@Controller
@RequestMapping("/eth")
public class UserController {
    @Autowired
    UserServiceImpl iEthService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        //insert
        User student = new User();
        student.setUserName("zhangsan1");
        student.setPassword("54");
        boolean res = iEthService.save(student);
        return res ? "success" : "fail";
    }
}


