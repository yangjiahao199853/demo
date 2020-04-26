package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:41
 */
@Mapper
public interface UserDao {
    /**
     * 用户注册
     * @param user
     */
    void register(User user);

    /**
     * 根据激活码查询用户，之后再进行修改用户状态
     * @param code
     * @return
     */
    User checkCode(String code);

    /**
     * 激活账户，修改用户状态为"1"
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
