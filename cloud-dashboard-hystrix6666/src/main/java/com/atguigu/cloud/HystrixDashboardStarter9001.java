package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardStarter9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardStarter9001.class, args);
    }
}
