package com.example.demo.service.impl;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserReq;
import com.example.demo.mapper.UserDao;
import com.example.demo.service.MailService;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MailServiceImpl mailService;

    /**
     * 用户注册，同时发送一封激活邮件
     * @param user
     */
    public void register(User user) {
        userDao.insert(user);
        String code = user.getCode();
        System.out.println("code:"+code);
        String subject = "来自xxx网站的激活邮件";
        //user/checkCode?code=xxx即是我们点击邮件链接之后进行更改状态的
        String context = "<a href=\"/user/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendHtmlMail (user.getUseremail(),subject,context);
    }

    /**
     * 根据激活码code进行查询用户，之后再进行修改状态
     * @param code
     * @return
     */
    public User checkCode(String code) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq(code!=null,"code",code);
        return userDao.selectById(ew);
    }

    /**
     * 激活账户，修改用户状态
     * @param user
     */
    public void updateUserStatus(User user) {
        userDao.updateById(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    public User loginUser(User user) {
        User user1 = userDao.selectOne(user);
        if (user1 !=null){
            return user1;
        }
        return null;
    }
}
