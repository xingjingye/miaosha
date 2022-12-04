package com.zzu.seckill;

import com.zzu.seckill.client.GoodsClient;
import com.zzu.seckill.client.OrderClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: seckill-demo02
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-24 13:04
 **/
@SpringBootApplication
@EnableFeignClients(clients = {GoodsClient.class, OrderClient.class})
public class SeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class,args);
    }
}
