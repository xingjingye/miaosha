package com.zzu.login.vo;

import lombok.Data;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-20 22:21
 **/
@Data
public class RegisterVO {
    private Long userId;
    private String nickname;
    private String password;
    private String address;
}
