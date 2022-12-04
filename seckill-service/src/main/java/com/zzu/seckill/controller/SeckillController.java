package com.zzu.seckill.controller;


import com.zzu.generalApi.pojo.User;
import com.zzu.generalApi.vo.RespBean;
import com.zzu.generalApi.vo.RespBeanEnum;
import com.zzu.seckill.client.GoodsClient;
import com.zzu.seckill.exception.GlobalException;
import com.zzu.seckill.pojo.Goods;
import com.zzu.seckill.pojo.Order;
import com.zzu.seckill.rabbitmq.MQSender;
import com.zzu.seckill.rabbitmq.SeckillMessage;
import com.zzu.seckill.service.SeckillService;

import com.zzu.seckill.util.JsonUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-19 14:42
 **/

@RestController
@RequestMapping("/seckill")
public class SeckillController implements InitializingBean {

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private MQSender mqSender;

    private final Map<Long,Boolean> emptyStockMap = new HashMap<>();


    @GetMapping("/{goodsId}")
    public RespBean<?> seckillGoods(@PathVariable("goodsId") Long goodsId, User user) {
        Order orderTmp = (Order) redisTemplate.opsForValue().get("orderTicket:" + user.getUserId() + ":" + goodsId);
        if (orderTmp != null) {
            throw new GlobalException(RespBeanEnum.REPEAT_ERROR);
        }
        if (emptyStockMap.get(goodsId)) {
            throw new GlobalException(RespBeanEnum.STOCK_ERROR);
        }
        Long stock = redisTemplate.opsForValue().decrement("seckillGoods:" + goodsId);
        assert stock != null;
        if (stock < 0) {
            redisTemplate.opsForValue().increment("seckillGoods:" + goodsId);
            emptyStockMap.put(goodsId,true);
            throw new GlobalException(RespBeanEnum.STOCK_ERROR);
        }
        SeckillMessage message = new SeckillMessage(goodsId,user);
        mqSender.sendSeckillMsg(JsonUtil.object2JsonStr(message));
        return RespBean.success();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<Goods> goodsList = goodsClient.getAllGoods().getData();
        for (Goods goods: goodsList) {
            redisTemplate.opsForValue().set("seckillGoods:" + goods.getGoodsId(),goods.getNum());
            emptyStockMap.put(goods.getGoodsId(), false);
        }
    }
}
