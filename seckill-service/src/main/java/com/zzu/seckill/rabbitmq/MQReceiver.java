package com.zzu.seckill.rabbitmq;

import com.zzu.generalApi.pojo.User;
import com.zzu.generalApi.vo.RespBean;
import com.zzu.generalApi.vo.RespBeanEnum;
import com.zzu.seckill.exception.GlobalException;
import com.zzu.seckill.pojo.Order;
import com.zzu.seckill.service.SeckillService;
import com.zzu.seckill.util.JsonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: seckill-demo02
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-26 09:23
 **/

@Service
public class MQReceiver{

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    SeckillService seckillService;

    @RabbitListener(queues = "seckillQueue")
    public void receiver(String msg) {
        SeckillMessage message = JsonUtil.jsonStr2Object(msg,SeckillMessage.class);
        assert message != null;
        Long goodsId = message.getGoodsId();
        User user = message.getUser();
        Order orderTmp = (Order) redisTemplate.opsForValue().get("orderTicket:" + user.getUserId() + ":" + goodsId);
        if (orderTmp != null) {
            redisTemplate.opsForValue().increment("seckillGoods" + goodsId);
            return;
        }
        seckillService.seckillGoods(goodsId,user);
    }
}
