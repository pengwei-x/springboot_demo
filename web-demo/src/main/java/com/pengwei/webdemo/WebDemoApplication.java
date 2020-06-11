package com.pengwei.webdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pengwei.webdemo.dao")
public class WebDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(WebDemoApplication.class, args);
        SpringApplication springApplication = new SpringApplication(WebDemoApplication.class);
//        springApplication.setXX();
        springApplication.run( args);
    }

}
