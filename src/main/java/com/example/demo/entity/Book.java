package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("book")
public class Book {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "book_Name")
    private String bookName;
    private String author;
    private BigDecimal price;
    @TableField(value = "publish_Time")
    private Date publishTime;
    @TableField(value = "update_Time")
    private Date updateTime;
    @TableField(value = "booksize")
    private Long bookSize;
}
