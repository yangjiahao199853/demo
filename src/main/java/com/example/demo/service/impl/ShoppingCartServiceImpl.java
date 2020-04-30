package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.example.demo.entity.ShoppingCart;
import com.example.demo.entity.ShoppingCartReq;
import com.example.demo.mapper.ShoppingCatDao;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.util.BeanUtil;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 10:32
 * @Version 1.0
 **/
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCatDao shoppingCatDao;

    public Boolean addShoppingCat(ShoppingCartReq shoppingCartReq) {
        ShoppingCart shoppingCart = BeanUtil.map(shoppingCartReq, ShoppingCart.class);
        List<ShoppingCart> list = selectShoppingCatByUserId(shoppingCart.getUserId());
        if (CollectionUtils.isNotEmpty(list)){
            list.forEach(ShoppingCart->{
                shoppingCatDao.insert(shoppingCart);
            });
        }else {
            shoppingCatDao.updateAllColumnById(shoppingCart);
        }
        return true;
    }


    public List<ShoppingCart> selectShoppingCatByUserId(Long Id) {
        ShoppingCartReq req = new ShoppingCartReq();
        req.setUserId(Id);
        EntityWrapper ew = getEntityWrapper(req);
        List<ShoppingCart> shoppingCartList = shoppingCatDao.selectList(ew);
        return shoppingCartList;
    }


    private EntityWrapper getEntityWrapper(ShoppingCartReq req) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq(req.getUserId() != null, "userId", req.getUserId());
        ew.eq(req.getBookId() != null, "bookId", req.getBookId());
        ew.eq(req.getQuantity() != null, "quantity", req.getQuantity());
        return ew;
    }
}
