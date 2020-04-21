package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:30
 * @Version 1.0
 **/
@Mapper
public class BookServiceImpl extends ServiceImpl<BookDao, Book> {
}
