package com.zzu.login.service.impl;

import com.zzu.generalApi.pojo.User;
import com.zzu.generalApi.vo.RespBean;
import com.zzu.generalApi.vo.RespBeanEnum;
import com.zzu.login.dao.UserDao;
import com.zzu.login.exception.GlobalException;
import com.zzu.login.service.UserService;
import com.zzu.login.util.CookieUtil;
import com.zzu.login.util.MD5Util;
import com.zzu.login.vo.LoginVO;
import com.zzu.login.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-18 12:25
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public RespBean<?> login(LoginVO loginVO, HttpServletRequest request, HttpServletResponse response) {
        User user = userDao.findUserById(loginVO.getUserId());
        if (user == null) {
            throw new GlobalException(RespBeanEnum.UNREGISTERED_ERROR);
        }
        if (!user.getPassword().equals(MD5Util.md5(loginVO.getPassword(),user.getSalt()))) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        if (redisTemplate.opsForValue().get(String.valueOf(user.getUserId())) != null) {
            throw new GlobalException(RespBeanEnum.RELOGIN_ERROR);
        }
        redisTemplate.opsForValue().set(String.valueOf(user.getUserId()),1);
        String ticket = UUID.randomUUID().toString().replace("-","");
        redisTemplate.opsForValue().set("userTicket:" + ticket,user);
        CookieUtil.setCookie(response,"JSESSIONID",ticket);
        return RespBean.success();
    }

    @Override
    public User getUserByTicket(String ticket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(ticket)) {
            throw new GlobalException(RespBeanEnum.SESSION_ERROR);
        }
        User user = (User) redisTemplate.opsForValue().get("userTicket:" + ticket);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.SESSION_ERROR);
        }
        CookieUtil.setCookie(response,"JSESSIONID",ticket);
        return user;
    }

    @Override
    public RespBean<?> register(@RequestBody RegisterVO registerVO) {
        if (redisTemplate.opsForValue().get(String.valueOf(registerVO.getUserId())) != null) {
            throw new GlobalException(RespBeanEnum.REGISTER_ERROR);
        }
        String salt = MD5Util.getSalt();
        String password = MD5Util.md5(registerVO.getPassword(),salt);
        userDao.registerUser(registerVO.getUserId(),registerVO.getNickname(), password, salt, registerVO.getAddress());
        return RespBean.success();
    }
}
