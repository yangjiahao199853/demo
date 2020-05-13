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

@ResponseBody
@RequestMapping("/book/")
@Controller
public class BookController {
    @Autowired
    BookServiceImpl bookService;
    @RequestMapping(value = "getBookById", method = RequestMethod.POST)
    public BookResp listByBookId(Long Id){
        return bookService.selectByBookId(Id);
    }

    @RequestMapping(value = "getBook", method = RequestMethod.POST)
    public List<BookResp> getBookResp(@RequestBody BookReq req){
        return bookService.selectBook(req);
    }

    @RequestMapping(value = "getBookResp", method = RequestMethod.POST)
    public List<BookResp> getBookAll(@RequestBody BookReq req){
        return bookService.selectBookAll(req);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Boolean updateBookById(@RequestBody BookReq req){
        return bookService.updateBookById(req);
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
    public Boolean saveBook(@RequestBody BookReq req){
        return bookService.saveBook(req);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Boolean deleteBook(@RequestBody BookReq req){
        return bookService.deleteBook(req);
    }


}
