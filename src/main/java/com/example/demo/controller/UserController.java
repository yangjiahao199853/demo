package com.example.demo.controller;

import com.example.demo.common.UUIDUtils;
import com.example.demo.entity.UserReq;
import com.example.demo.entity.UserResp;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:38
 */

@ResponseBody
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/registerUser")
    public String register(User user){
        user.setStatus(0);
        String code = UUIDUtils.getUUID()+ UUIDUtils.getUUID();
        user.setCode(code);
        userService.register(user);
        return "success";
    }

    /**
     *校验邮箱中的code激活账户
     * 首先根据激活码code查询用户，之后再把状态修改为"1"
     */
    @RequestMapping(value = "/checkCode")
    public String checkCode(String code){
        List<User> listUser = userService.checkCode(code);
        System.out.println(listUser);
        //如果用户不等于null，把用户状态修改status=1
        listUser.forEach(user -> {
            if (user !=null){
                user.setStatus(1);
                //把code验证码清空，已经不需要了
                user.setCode("");
                System.out.println(user);
                userService.updateUserStatus(user);
            }
        });

        return "login";
    }

    /**
     * 跳转到登录页面
     * @return login
     */
    @RequestMapping(value = "/loginPage")
    public String login(){
        return "login";
    }


//    @RequestMapping(value = "/loginUser")
//    public String login(UserReq userReq){
//        User u = userService.loginUser(userReq);
//        if (u !=null){
//            return "welcome";
//        }
//        return "login";
//    }


    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/loginUser",method = { RequestMethod.POST, RequestMethod.GET })
    public  String setCookies(HttpServletRequest request,UserReq user){
       List<UserResp> userResps = userService.loginUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("userId", userResps.get(0).getId());
        if (userResps !=null){
            return "welcome";
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/getSession",method = { RequestMethod.POST, RequestMethod.GET })
    public String getCookies(HttpServletRequest request){
        HttpSession session = request.getSession();
        String data = (String) session.getAttribute("userId");
        return data;
    }

    @GetMapping("/getLoginUserInfo")
    public Object getLoginUserInfo(User user) {
        return user;
    }
}


