package com.example.demo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookReq;
import com.example.demo.entity.BookResp;
import com.example.demo.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @RequestMapping(value = "getBookById", method = RequestMethod.GET)
    public BookResp listByBookId(@RequestParam Long Id){
        return bookService.selectByBookId(Id);
    }

    @RequestMapping(value = "getBook", method = RequestMethod.GET)
    public List<BookResp> getBookResp(@RequestBody BookReq req){
        return bookService.selectBook(req);
    }

    @RequestMapping(value = "getBookPage", method = RequestMethod.GET)
    public Page<Book> getBookAllPage(@RequestBody BookReq req){
        return bookService.selectBookPage(req);
    }


    @RequestMapping(value = "update", method = {RequestMethod.POST, RequestMethod.GET})
    public Boolean updateBookById(@RequestBody BookReq req){
        return bookService.updateBookById(req);
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST, RequestMethod.GET})
    public Boolean saveBook(@RequestBody BookReq req){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        return bookService.saveBook(req);
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST, RequestMethod.GET})
    public Boolean deleteBook(@RequestBody BookReq req){
        return bookService.deleteBook(req);
    }


}
