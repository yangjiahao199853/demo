package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/26 22:29
 */
@Data
public class UserReq {
    public Long id;
    public String userName;
    public String password;
    public String useremail;
    public int status;
    public String code;
    public String authorities;
}
