package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("shopping_cat")
public class ShoppingCart {
    @TableId(value = "id")
    private Long id;
    @TableField(value = "book_id")
    private Long bookId;
    @TableField(value = "user_id")
    private Long userId;
    private int num;
    private BigDecimal price;
}
