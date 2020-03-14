package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import com.atguigu.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/*
 *-----------------神兽保佑 -----------------
 *           ┌─┐        ┌─┐
 *       ┌─┘  ┴────┘  ┴─┐
 *       │                        │
 *       │        ───          │
 *       │  ─┬┘       └┬─   │
 *       │                        │
 *       │       ─┴─           │
 *       │                        │
 *       └───┐          ┌──┘
 *               │          │
 *               │          │
 *               │          │
 *               │          └────────────┐
 *               │                                    │
 *               │                                    ├─┐
 *               │                                    ┌─┘
 *               │                                    │
 *               └─┐  ┐  ┌─────┬─┐  ┌──┘
 *                   │  ┤  ┤          │  ┤  ┤
 *                   └─┴─┘          └─┴─┘
 *
 * ------------------代码无BUG!--------------
 * @Author: Seesky
 * @Date: 2020/3/7 18:51
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer serverPort;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/info/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        String result = paymentService.paymentInfo(id);

        return new CommonResult(200, "查询成功,serverPort: " + serverPort, result);

    }

    @GetMapping(value = "/payment/timeout/{id}")
    public CommonResult timeout(@PathVariable("id") Long id) {
        String result = paymentService.timeout(id);

        return new CommonResult(200, "查询成功,serverPort: " + serverPort, result);

    }

    /**
     * {@link com.netflix.hystrix.HystrixCommandProperties label}
     */
    @GetMapping(value = "/payment/CircuitBreaker/{id}")
    @HystrixCommand(fallbackMethod = "CircuitBreakerFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold" ,value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" ,value="10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" ,value="60")//失败率
    })
    public CommonResult CircuitBreaker(@PathVariable("id") Long id) {
        if(id <= 0 ){
            throw new RuntimeException(" id 不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return new CommonResult(200, "查询成功,serverPort: " + serverPort + "uuid : ", uuid);

    }

    /**
     * 非默认降级返回值必须一致
     * Fallback method 'public java.lang.String com.atguigu.cloud.controller.PaymentController.CircuitBreakerFallBack(java.lang.Long)'
     * must return: class com.atguigu.cloud.entities.CommonResult or its subclass
     * @param id
     * @return
     */
    public CommonResult CircuitBreakerFallBack(@PathVariable("id") Long id) {

        return new CommonResult(200, "fail","CircuitBreakerFallBack");

    }

}
