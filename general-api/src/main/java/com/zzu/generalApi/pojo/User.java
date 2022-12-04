package com.zzu.generalApi.pojo;

import lombok.Data;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-17 19:02
 **/

@Data
public class User {
    private Long userId;
    private String nickname;
    private String password;
    private String salt;
    private String address;
}
