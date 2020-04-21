package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:55
 * @Version 1.0
 **/
@Data
@ToString
public class BookResp {
    /**
     * 书籍ID
     */
    private Long book_Id;
    /**
     * 书籍名称
     */
    private String book_Name;
    /**
     * 作家
     */
    private String author;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 开本
     */
    private Long bookSize;
}
