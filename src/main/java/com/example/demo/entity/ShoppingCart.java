package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "")
public class ShoppingCart {
    private Long id;
    private Long quantity;
    private String bookId;
    private Long userId;
    private Long orderBy;
}
