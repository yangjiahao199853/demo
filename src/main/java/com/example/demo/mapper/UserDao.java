package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:41
 */
@RequestMapping
public interface UserDao extends BaseMapper<User> {
}
