package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentStarter8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentStarter8003.class, args);
    }
}
