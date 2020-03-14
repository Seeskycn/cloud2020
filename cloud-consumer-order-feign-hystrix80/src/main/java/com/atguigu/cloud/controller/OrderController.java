package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import com.atguigu.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date: 2020/3/7 21:21
 * @Description:
 */
@RestController
@DefaultProperties(defaultFallback = "dfFallBack")
public class OrderController {


    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/info/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "timeoutFallBack" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value="1500")
    })*/
   //@HystrixCommand
    public CommonResult timeout(@PathVariable("id") Long id) throws InterruptedException {
        return paymentService.timeout(id);
    }


    public CommonResult timeoutFallBack(Long id) {
        return new CommonResult(200,"成功","defaultFallBack");
    }

    /**
     * 全局 fallback 配置无参即可,如果带有参数会报错,找不到 fallback
     * @return
     */
    public CommonResult dfFallBack() {
        return new CommonResult(200,"成功","defaultFallBack");
    }
}
