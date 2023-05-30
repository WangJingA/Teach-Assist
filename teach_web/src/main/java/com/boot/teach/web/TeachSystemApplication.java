package com.boot.teach.web;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 启动类
 */

@MapperScan(basePackages = {"com.boot.teach.dao"})
@ComponentScan(basePackages = {"com.boot.teach"})
@SpringBootApplication
public class TeachSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeachSystemApplication.class,args);
    }
}
