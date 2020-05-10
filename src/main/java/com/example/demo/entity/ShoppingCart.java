package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("shopping_Cat")
public class ShoppingCart {
    @TableId(value = "id")
    public Long id;
    public Long quantity;
    @TableField(value = "book_Id")
    public Long bookId;
    @TableField(value = "user_Id")
    public Long userId;

}
