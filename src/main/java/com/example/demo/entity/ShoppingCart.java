package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName(value = "")
public class ShoppingCart {
    public Long id;
    public Long quantity;
    public String bookId;
    public Long userId;
    public Long orderBy;
}
