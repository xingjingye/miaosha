package com.zzu.login.exception;

import com.zzu.generalApi.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-18 20:58
 **/
@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    RespBeanEnum respBeanEnum;
}
