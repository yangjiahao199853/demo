package com.example.demo.entity;

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
public class User implements Serializable{
    private String id;
    private String userName;
    private String Password;
    private String status;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + Password + '\'' +
                '}';
    }
}

