package com.doublez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 开启Eureka服务
@SpringBootApplication
public class Eureka8080Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8080Application.class, args);
    }

}
