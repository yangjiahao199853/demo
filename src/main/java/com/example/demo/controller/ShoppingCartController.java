package com.example.demo.controller;


import com.example.demo.entity.ShoppingCartReq;
import com.example.demo.entity.ShoppingCartResp;
import com.example.demo.entity.User;
import com.example.demo.service.impl.ShoppingCartServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/addShoppingCat",method = { RequestMethod.POST, RequestMethod.GET })
    public Boolean addShoppingCat(@RequestBody ShoppingCartReq req){
        User user=userService.getUserInfoById(SecurityContextHolder.getContext().getAuthentication().getName());
        req.setUserId(user.getId());
        return shoppingCartService.addShoppingCat(req);
    }

    @RequestMapping(value = "/getSelectShoppingCart",method = { RequestMethod.POST, RequestMethod.GET })
    public List<ShoppingCartResp> getSelectShoppingCart(@RequestBody ShoppingCartReq req){
        User user=userService.getUserInfoById(SecurityContextHolder.getContext().getAuthentication().getName());
        req.setUserId(user.getId());
        return shoppingCartService.selectShoppingCatByUserId(req);
    }

    @RequestMapping(value = "/deleteShoppingCart",method = { RequestMethod.POST, RequestMethod.GET })
    public Integer deleteShoppingCart(@RequestParam Long UserId){
        return shoppingCartService.deleteShoppingCat(UserId);
    }

}
