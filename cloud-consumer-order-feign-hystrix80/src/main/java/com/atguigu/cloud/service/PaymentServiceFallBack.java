package com.atguigu.cloud.service;

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
 * @Date: 2020/3/14 13:02
 * @Description:
 */

import com.atguigu.cloud.entities.CommonResult;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceFallBack implements PaymentService {

    @Override
    public CommonResult getPaymentById(Long id) {
        return null;
    }

    @Override
    public CommonResult timeout(Long id) {

        return new CommonResult(200, "success","PaymentServiceFallBack service Fallback");
    }
}
