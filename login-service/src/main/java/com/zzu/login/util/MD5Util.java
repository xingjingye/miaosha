package com.zzu.login.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-20 21:27
 **/
public class MD5Util {

    private static final String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getSalt() {
        return "" + base.charAt(getRandom()) + base.charAt(getRandom()) + base.charAt(getRandom()) + base.charAt(getRandom());
    }

    public static int getRandom() {
        return new Random().nextInt(base.length());
    }

    public static String md5(String password,String salt) {
        String tmp = DigestUtils.md5Hex(password) + salt;
        return DigestUtils.md5Hex(tmp);
    }
}
