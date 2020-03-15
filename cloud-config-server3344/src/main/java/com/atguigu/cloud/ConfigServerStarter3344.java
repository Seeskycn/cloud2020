package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
public class ConfigServerStarter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerStarter3344.class, args);

    }
}
