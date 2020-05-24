package com.example.demo.service.impl;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.util.BeanUtil.*;


/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:30
 * @Version 1.0
 **/
@Service
@Repository
public class BookServiceImpl extends ServiceImpl<BookDao, Book> {

    @Autowired
    private BookService bookService;

    public static final String BOOK_NAME = "book_Name";


    public BookResp selectByBookId(Long Id){
        Book book=bookService.selectById(Id);
        BookResp bookResp=new BookResp();
        BeanUtils.copyProperties(book, bookResp);
        return bookResp;
    }


    /**
     * 通过书名或作者查询书籍,或查询全部
     * @param req
     * @return
     */
    public List<BookResp> selectBook(BookReq req){
        EntityWrapper ew = getEw(req);
        List<BookResp> bookResps=bookService.selectList(ew);
        return bookResps;
    }

    public List<BookResp> selectBookAll(BookReq req){
        EntityWrapper ew = getEw(req);
        List<Book> book=bookService.selectList(ew);
        List<BookResp> resultList = book.stream().map(data -> map(data, BookResp.class)).collect(Collectors.toList());
        return resultList;
    }

    public Boolean updateBookById(BookReq req){
        Book book= map(req,Book.class);
        book.setUpdateTime(new Date());
        bookService.updateById(book);
        return true;
    }


    public Boolean saveBook(BookReq req){
        Book book= map(req,Book.class);
        book.setUpdateTime(new Date());
        bookService.insert(book);
        return true;
    }


    public Boolean deleteBook(BookReq req){
        bookService.deleteBatchIds(req.getIds());
        return true;
    }

    private EntityWrapper getEw(BookReq req){
        EntityWrapper ew = new EntityWrapper<>();
        ew.eq(req.getBookId()!=null,"id",req.getBookId())
                .eq(Strings.isNotEmpty(req.getAuthor()),"author",req.getAuthor());
        if (StringUtils.isNotEmpty(req.getBookName())){
            ew.like(BOOK_NAME,req.getBookName(), SqlLike.DEFAULT);
        }
        ew.orderDesc(Lists.newArrayList("update_time"));
        return ew;
    }

    public Page<Book> selectBookPage(BookReq req){
        Page<Book> page = new Page<>(req.getPageNum(), req.getPageSize());// 当前页，总条数 构造 page 对象
        //sql优化，OptimizeCountSql默认为true，优化，不执行select count(1)操作
        //page.setOptimizeCountSql(false);
        // 查询总记录数，默认是查询
        // page.setSearchCount(false);
        // 注意！！ 分页 total 是经过插件自动 回写 到传入 page 对象
        EntityWrapper ew = getEw(req);
        return page.setRecords(baseMapper.selectMapsPage(page, ew));
    }
}
