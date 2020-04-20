package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:40
 */
@Data
@TableName("user")
public class User {
    @TableId(value = "user_id")
    private Long userId;
    private String userName;
    private String password;
}

