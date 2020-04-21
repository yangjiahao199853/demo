package com.example.demo.service.impl;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookReq;
import com.example.demo.entity.BookResp;
import com.example.demo.mapper.BookDao;
import com.example.demo.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:30
 * @Version 1.0
 **/
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> {

    @Autowired
    private BookService bookService;

    public static final String BOOK_NAME = "book_Name";

    public BookResp selectByBookId(Long Id){
        Book book=bookService.selectById(Id);
        BookResp bookResp=new BookResp();
        BeanUtils.copyProperties(bookResp, book);
        return bookResp;
    }


    public BookResp listByBookId(BookReq req){
        EntityWrapper ew = getEw(req);
        List<Book> book=bookService.selectList(ew);
        BookResp bookResp=new BookResp();
        BeanUtils.copyProperties(bookResp, book);
        return bookResp;
    }

    private EntityWrapper getEw(BookReq req){
        EntityWrapper ew = new EntityWrapper<>();
        ew.eq(req.getBookId()!=null,"id",req.getBookId())
                .eq(!Strings.isNotEmpty(req.getAuthor()),"author",req.getAuthor());
        if (StringUtils.isNotEmpty(req.getBookName())){
            ew.andNew().like(BOOK_NAME,req.getBookName(), SqlLike.DEFAULT);
        }
        ew.orderDesc(Lists.newArrayList("update_time"));
        return ew;
    }
}
