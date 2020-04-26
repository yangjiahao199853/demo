package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author YangJiaHao
 * @Date 2020/4/21 17:53
 * @Version 1.0
 **/
@Configuration
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidConfig(){

        return new DruidDataSource();
    }
}
