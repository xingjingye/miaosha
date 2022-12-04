package com.zzu.seckill.service;


import com.zzu.generalApi.pojo.User;
import com.zzu.generalApi.vo.RespBean;

public interface SeckillService {
    RespBean seckillGoods(Long goodsId, User user);
}
