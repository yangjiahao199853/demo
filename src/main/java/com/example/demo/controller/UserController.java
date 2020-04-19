package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.User;

import java.util.List;


/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:38
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    public String getAll() {
        List<User> list = userService.list();
        System.out.println("list:" + list);
        return list.toString();
    }

    @RequestMapping("/insert")
    public String insert() {
        User user = new User();
        // 不设置id的话，会自动生成一个UUID
//        user.setId(new Date().getTime() + "");
        user.setUserName("aaa");
        user.setUserPassword("bbb");
        boolean save = userService.save(user);
        return getAll();
    }
}


