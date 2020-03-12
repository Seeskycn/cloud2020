package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignStarter80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignStarter80.class, args);
    }
}
