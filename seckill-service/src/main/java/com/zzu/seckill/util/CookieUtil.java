package com.zzu.seckill.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-19 17:18
 **/

public class CookieUtil {

    public static void setCookie(HttpServletResponse response,String cookieName,String cookieValue) {
        Cookie cookie = new Cookie(cookieName,cookieValue);
        response.addCookie(cookie);
    }

    public static String getCookieValue(HttpServletRequest request,String cookieName) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
