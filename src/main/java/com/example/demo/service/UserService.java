package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:42
 */
@Service
public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    void register(User user);

    /**
     * 根据激活码code查询用户，之后再进行修改状态
     * @param code
     * @return
     */
    User checkCode(String code);

    /**
     * 激活账户，修改用户状态
     * @param user
     */
    void updateUserStatus(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User loginUser(User user);
}