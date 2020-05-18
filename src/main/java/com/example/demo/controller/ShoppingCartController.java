package com.example.demo.controller;

import com.example.demo.entity.ShoppingCart;
import com.example.demo.entity.ShoppingCartReq;
import com.example.demo.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @ResponseBody
    @RequestMapping(value = "/getSelectShoppingCart",method = { RequestMethod.POST, RequestMethod.GET })
    public List<ShoppingCart> getSelectShoppingCart(HttpServletRequest request, ShoppingCartReq req){
        HttpSession session = request.getSession();
        Long data = (Long) session.getAttribute("userId");
        req.setUserId(data);
        return shoppingCartService.selectShoppingCatByUserId(req);
    }


    @ResponseBody
    @RequestMapping(value = "/addShoppingCat",method = { RequestMethod.POST, RequestMethod.GET })
    public Boolean addShoppingCat(HttpServletRequest request, ShoppingCartReq req){
        HttpSession session = request.getSession();
        Long data = (Long) session.getAttribute("userId");
        req.setUserId(data);
        return shoppingCartService.addShoppingCat(req);
    }
}
