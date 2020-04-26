package com.example.demo.common;

import java.util.UUID;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/26 22:25
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
