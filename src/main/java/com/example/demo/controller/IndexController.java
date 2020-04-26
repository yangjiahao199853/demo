package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/26 22:51
 */
@Controller
public class IndexController {
    /**
     * 首页
     */
    @RequestMapping(value = "/")
    public String index(){

        return "index";
    }
}
