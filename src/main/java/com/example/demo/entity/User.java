package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:40
 */
@Data
@TableName("user")
public class User {
    @TableId(value = "id")
    public Long id;
    public String name;
    public String password;
    public String email;
}

