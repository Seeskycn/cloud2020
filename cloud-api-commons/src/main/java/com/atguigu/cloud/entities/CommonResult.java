package com.atguigu.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 * @Date: 2020/3/7 18:56
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>  {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static<T> CommonResult<T> buildSuccess(T t){

        return new CommonResult<T>(200,"成功" , t);
    }

    public static<T> CommonResult<T> buildFail(T t){

        return new CommonResult<T>(500,"失败" , t);
    }
}
