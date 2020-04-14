package com.doublez;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.doublez.mapper")
@SpringBootApplication
public class Provider8090Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider8090Application.class, args);
    }
}
