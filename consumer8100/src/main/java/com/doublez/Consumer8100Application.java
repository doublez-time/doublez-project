package com.doublez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //开启Feign客户端
@SpringCloudApplication
public class Consumer8100Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8100Application.class, args);
    }

}
