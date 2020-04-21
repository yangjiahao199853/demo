package com.example.demo.controller;

import com.example.demo.entity.BookReq;
import com.example.demo.entity.BookResp;
import com.example.demo.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:37
 * @Version 1.0
 **/
@Controller
@ResponseBody
@RequestMapping("/Book")
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    public BookResp listByBookId(Long Id){
        return bookService.selectByBookId(Id);
    }

    public BookResp BookResp(BookReq req){
        return bookService.selectBookAll(req);
    }

}
