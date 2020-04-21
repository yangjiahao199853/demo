package com.example.demo.controller;

import com.example.demo.entity.BookReq;
import com.example.demo.entity.BookResp;
import com.example.demo.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:37
 * @Version 1.0
 **/
@RestController
@ResponseBody
@RequestMapping("/Book/")
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    public BookResp listByBookId(Long Id){
        return bookService.selectByBookId(Id);
    }

    @RequestMapping(value = "getBookResp", method = RequestMethod.POST)
    public List<BookResp> getBookResp(@RequestBody BookReq req){
        return bookService.selectBook(req);
    }

    @RequestMapping(value = "getBookResp", method = RequestMethod.POST)
    public List<BookResp> getBookAll(@RequestBody BookReq req){
        return bookService.selectBookAll(req);
    }

}
