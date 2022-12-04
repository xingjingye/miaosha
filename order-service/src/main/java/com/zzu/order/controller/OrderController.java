package com.zzu.order.controller;

import com.zzu.order.pojo.Order;
import com.zzu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-22 15:54
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    
    @PostMapping ("/insert")
    public Boolean insertOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }
}
