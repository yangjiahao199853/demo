package com.example.demo.controller;

import com.example.demo.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:43
 * @Version 1.0
 **/
@RequestMapping("/Shopping")
@ResponseBody
@Controller
public class ShoppingCartController {

    @Autowired
    ShoppingCartServiceImpl shoppingCartService;
}
