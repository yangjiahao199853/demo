package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/19 21:40
 */
@Data
@TableName("user")
public class User  implements UserDetails, Serializable {
    @TableId(value = "user_id",type = IdType.AUTO)
    public Long id;
    @TableField(value = "username")
    public String userName;
    public String password;
    public String useremail;
    public int status;
    public String code;

    private List<Role> authorities;

    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    /**
     * 用户账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户账号是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}

