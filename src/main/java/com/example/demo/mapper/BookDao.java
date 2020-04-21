package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:19
 * @Version 1.0
 **/
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
