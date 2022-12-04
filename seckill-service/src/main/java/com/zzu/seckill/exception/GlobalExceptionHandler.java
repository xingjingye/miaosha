package com.zzu.seckill.exception;

import com.zzu.generalApi.vo.RespBean;
import com.zzu.generalApi.vo.RespBeanEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-18 20:59
 **/

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RespBean<?> ExceptionHandler(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return RespBean.error(ex.respBeanEnum);
        }
        System.out.println(e);
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
