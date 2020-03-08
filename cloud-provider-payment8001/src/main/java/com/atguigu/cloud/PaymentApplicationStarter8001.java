package com.atguigu.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan("com.atguigu.cloud.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentApplicationStarter8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationStarter8001.class, args);
    }
}
