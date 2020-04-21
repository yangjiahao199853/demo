package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 11:01
 * @Version 1.0
 **/
@Data
public class BookReq {
    /**
     * 书籍ID
     */
    public Long bookId;
    /**
     * 书籍名称
     */
    public String bookName;
    /**
     * 作家
     */
    public String author;
    /**
     * 价格
     */
    public BigDecimal price;
    /**
     * 发布时间
     */
    public Date publishTime;
    /**
     * 开本
     */
    public Long bookSize;
    public Integer  pageNum;;
    public Integer  pageSize;;
}
