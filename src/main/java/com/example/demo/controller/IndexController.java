package com.example.demo.controller;

import com.example.demo.entity.BookReq;
import com.example.demo.entity.BookResp;
import com.example.demo.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/26 22:51
 */
@Controller
public class IndexController {


    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute( "loginError"  , true);
        return "login";
    }

    @GetMapping("/401")
    public String accessDenied() {
        return "401";
    }

    @GetMapping("user/common")
    public String common() {
        BookReq req=new BookReq();
        List<BookResp> list=bookService.selectBook(req);
        list.forEach(x->{
            System.out.printf(x.toString());
        });
        return "user/common";
    }

    @GetMapping("user/admin")
    public String admin() {
        return "user/admin";
    }

}
