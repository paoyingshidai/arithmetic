package com.michael.arithmetic.presort;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.michael.arithmetic.presort.repository")
public class PresortApplication {

    public static void main(String[] args) {

        SpringApplication.run(PresortApplication.class, args);
    }
}
