package com.example.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.entity.ShoppingCart;
import com.example.demo.entity.ShoppingCartReq;
import com.example.demo.mapper.ShoppingCatDao;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.util.BeanUtil;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:32
 * @Version 1.0
 **/
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCatDao shoppingCatDao;

    private Boolean addShoppingCat(ShoppingCartReq shoppingCartReq){
        ShoppingCart shoppingCart= BeanUtil.map(shoppingCartReq,ShoppingCart.class);
        shoppingCatDao.insert(shoppingCart);
        return true;
    }


}
