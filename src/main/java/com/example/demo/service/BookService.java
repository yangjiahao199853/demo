package com.example.demo.service;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:29
 * @Version 1.0
 **/
@Service
public interface BookService extends BaseMapper<Book> {
}
