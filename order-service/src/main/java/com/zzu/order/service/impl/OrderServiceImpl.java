package com.zzu.order.service.impl;

import com.zzu.order.dao.OrderDao;
import com.zzu.order.pojo.Order;
import com.zzu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-19 18:58
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public Boolean insertOrder(Order order) {
        return orderDao.insertOrder(order.getUserId(), order.getGoodsId(),order.getGoodsName(),order.getGoodsPrice(),
                order.getGoodsNum(),order.getAddress(),order.getCreateTime());
    }
}
