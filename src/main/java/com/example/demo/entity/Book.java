package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "")
public class Book {
    @TableField(value = "create_by")
    private Long book_Id;
    private String book_Name;
    private String author;
    private String price;
    private Date publishTime;
    private Long bookSize;
    private Long orderBy;
}
