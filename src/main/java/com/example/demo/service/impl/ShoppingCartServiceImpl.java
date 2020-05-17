package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.example.demo.entity.*;
import com.example.demo.mapper.BookDao;
import com.example.demo.mapper.ShoppingCatDao;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.util.BeanUtil;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:32
 * @Version 1.0
 **/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCatDao, ShoppingCart> {
    @Autowired
    private ShoppingCatDao shoppingCatDao;

    @Autowired
    private BookServiceImpl BookService;

    public Boolean addShoppingCat(ShoppingCartReq shoppingCartReq) {
        ShoppingCart shoppingCart = BeanUtil.map(shoppingCartReq, ShoppingCart.class);
        EntityWrapper ew = getEntityWrapper(shoppingCartReq);
        List<ShoppingCart> stringShoppingCart = shoppingCatDao.selectList(ew);
        if (stringShoppingCart.isEmpty()) {
            shoppingCatDao.insert(shoppingCart);
        } else {
            shoppingCart.setId(stringShoppingCart.get(0).getId());
            shoppingCatDao.updateAllColumnById(shoppingCart);
        }
        return true;
    }


    public List<ShoppingCartResp> selectShoppingCatByUserId(ShoppingCartReq req) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq(StringUtils.isNotEmpty(req.getUserId().toString()), "user_id", req.getUserId());
        List<ShoppingCart> list = shoppingCatDao.selectList(ew);
        List<ShoppingCartResp> shoppingCartRespList = new ArrayList<>();
        list.forEach(x -> {
            ShoppingCartResp resp = new ShoppingCartResp();
            BookResp bookResp = BookService.selectByBookId(x.getBookId());
            resp.setBookId(bookResp.getBookId());
            resp.setNum(x.getNum());
            resp.setUserId(x.getUserId());
            resp.setPrice(x.getPrice());
            resp.setBookResp(bookResp);
            shoppingCartRespList.add(resp);
        });
        return shoppingCartRespList;
    }


    public Integer deleteShoppingCat(Long UserId) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq(StringUtils.isNotEmpty(UserId.toString()), "user_id", UserId);
        return shoppingCatDao.delete(ew);
    }


    private EntityWrapper getEntityWrapper(ShoppingCartReq req) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq(req.getUserId() != null, "user_Id", req.getUserId());
        ew.eq(req.getBookId() != null, "book_Id", req.getBookId());
        return ew;
    }
}
