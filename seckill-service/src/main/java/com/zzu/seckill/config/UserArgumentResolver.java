package com.zzu.seckill.config;

import com.zzu.generalApi.pojo.User;
import com.zzu.generalApi.vo.RespBeanEnum;
import com.zzu.seckill.exception.GlobalException;
import com.zzu.seckill.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-19 22:54
 **/
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        assert request != null;
        String ticket = CookieUtil.getCookieValue(request,"JSESSIONID");
        if (ticket == null) {
            return null;
        }
        if (StringUtils.isEmpty(ticket)) {
            throw new GlobalException(RespBeanEnum.SESSION_ERROR);
        }
        User user = (User) redisTemplate.opsForValue().get("userTicket:" + ticket);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.SESSION_ERROR);
        }
        assert response != null;
        CookieUtil.setCookie(response,"JSESSIONID",ticket);
        return user;
    }
}
