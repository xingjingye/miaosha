package com.zzu.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-18 20:53
 **/

@Data
@AllArgsConstructor
public class RespBean<T> {

    int code;
    String msg;
    T data;

    public static RespBean<?> success() {
        return new RespBean<>(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMsg(), null);
    }

    public static <V> RespBean<V> success(V data) {
        return new RespBean<V>(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMsg(), data);
    }

    public static RespBean<?> error(RespBeanEnum respBeanEnum) {
        return new RespBean<>(respBeanEnum.getCode(), respBeanEnum.getMsg(), null);
    }

    public static <V> RespBean<V> error(RespBeanEnum respBeanEnum, V data) {
        return new RespBean<V>(respBeanEnum.getCode(), respBeanEnum.getMsg(), data);
    }
}
