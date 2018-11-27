package com.michael.arithmetic.presort;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//        (exclude={DruidDataSourceAutoConfigure.class})
@MapperScan(basePackages = "com.michael.arithmetic.presort.repository")
public class PresortApplication {

    public static void main(String[] args) {

        SpringApplication.run(PresortApplication.class, args);
    }
}
