package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/11 17:00
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(){
        return "彭佳琪是猪，就知道吃吃吃";
    }
}
