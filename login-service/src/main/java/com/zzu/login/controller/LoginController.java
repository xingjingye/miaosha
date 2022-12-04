package com.zzu.login.controller;

import com.zzu.generalApi.vo.RespBean;
import com.zzu.login.service.UserService;
import com.zzu.login.vo.LoginVO;
import com.zzu.login.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-17 19:50
 **/

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @PostMapping ("/toLogin")
    public RespBean login(@RequestBody LoginVO loginVO, HttpServletRequest request, HttpServletResponse response) {
        return userService.login(loginVO,request,response);
    }

    @PostMapping("/register")
    public RespBean register(@RequestBody RegisterVO registerVO) {
        return userService.register(registerVO);
    }

}
