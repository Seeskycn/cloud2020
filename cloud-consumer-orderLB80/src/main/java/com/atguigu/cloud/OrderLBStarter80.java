package com.atguigu.cloud;

import com.atguigu.RibbonRule.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Hello world!
 */
@SpringBootApplication
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT",configuration = RibbonConfig.class)
public class OrderLBStarter80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderLBStarter80.class, args);
    }
}
