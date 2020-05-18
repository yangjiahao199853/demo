package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/29 22:03
 */
@Data
public class ShoppingCartResp {
    private Long userId;
    private Long bookId;
    private BigDecimal price;
    private int num;
    private BookResp bookResp;
}
