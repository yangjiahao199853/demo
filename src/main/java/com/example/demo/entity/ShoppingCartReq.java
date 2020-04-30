package com.example.demo.entity;


import lombok.Data;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/29 22:03
 */
@Data
public class ShoppingCartReq {
    private Long quantity;
    private Long bookId;
    private Long userId;
}
