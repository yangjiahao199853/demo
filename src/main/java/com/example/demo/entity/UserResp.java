package com.example.demo.entity;

import lombok.Data;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/26 22:30
 */
@Data
public class UserResp {
    public Long id;
    public String userName;
    public String password;
    public String useremail;
    public int status;
    public String code;
}
