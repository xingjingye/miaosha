package com.zzu.seckill.service.impl;

import com.zzu.generalApi.pojo.User;
import com.zzu.generalApi.vo.RespBean;
import com.zzu.generalApi.vo.RespBeanEnum;
import com.zzu.seckill.client.GoodsClient;
import com.zzu.seckill.client.OrderClient;
import com.zzu.seckill.dao.SeckillDao;
import com.zzu.seckill.pojo.Goods;
import com.zzu.seckill.pojo.Order;
import com.zzu.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-19 15:18
 **/
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    SeckillDao seckillDao;

    @Autowired
    GoodsClient goodsClient;

    @Autowired
    OrderClient orderClient;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    @Override
    public RespBean<?> seckillGoods(Long goodsId, User user) {
        Goods goods = goodsClient.getGoodsById(goodsId).getData();
        if (goods.getNum() > 0) {
            if (seckillDao.seckill(goodsId)) {
                Order order = new Order();
                order.setUserId(user.getUserId());
                order.setGoodsId(goods.getGoodsId());
                order.setGoodsName(goods.getName());
                order.setGoodsPrice(goods.getPrice());
                order.setGoodsNum(1);
                order.setAddress(user.getAddress());
                order.setCreateTime(new Date());
                orderClient.insertOrder(order);
                redisTemplate.opsForValue().set("orderTicket:" + user.getUserId() + ":" + goodsId,order);
                return RespBean.success(order);
            } else {
                return RespBean.error(RespBeanEnum.STOCK_ERROR);
            }
        } else {
            return RespBean.error(RespBeanEnum.STOCK_ERROR);
        }
    }
}
