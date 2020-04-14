package com.doublez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class Gateway9000Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9000Application.class, args);
    }

}
