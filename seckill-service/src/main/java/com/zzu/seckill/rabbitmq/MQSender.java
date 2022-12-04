package com.zzu.seckill.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seckill-demo02
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-26 09:18
 **/

@Service
public class MQSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendSeckillMsg(String msg) {
        rabbitTemplate.convertAndSend("seckillExchange","seckill.msg",msg);
    }
}
