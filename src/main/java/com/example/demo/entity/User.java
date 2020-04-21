package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:40
 */
@Data
@TableName("user")
public class User {
    @TableId(value = "user_id",type = IdType.AUTO)
    public Long id;
    @TableField(value = "user_name")
    public String userName;
    public String password;
    public String email;
    public String status;
}

