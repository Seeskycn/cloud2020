package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkStarter80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkStarter80.class, args);
    }
}
