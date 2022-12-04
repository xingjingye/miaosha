package com.zzu.seckill.client;

import com.zzu.seckill.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("orderservice")
public interface OrderClient {

    @PostMapping("/order/insert")
    Boolean insertOrder(@RequestBody Order order);
}
