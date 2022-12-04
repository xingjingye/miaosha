package com.zzu.order.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum RespBeanEnum {

    //通用模块
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常"),

    //自定义模块
    UNREGISTERED_ERROR(500100,"用户未注册"),
    LOGIN_ERROR(500200,"密码错误"),
    SESSION_ERROR(500300,"用户未登录"),
    RELOGIN_ERROR(500400,"不能重复登录"),
    REGISTER_ERROR(500500,"该账号已被注册"),
    REPEAT_ERROR(500600,"每个ID限购一件"),
    STOCK_ERROR(500700,"库存不足");
    int code;
    String msg;
}

