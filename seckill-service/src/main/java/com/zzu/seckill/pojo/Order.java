package com.zzu.seckill.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-17 19:03
 **/

@Data
public class Order {
    private Long orderId;
    private Long userId;
    private Long goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private int goodsNum;
    private String address;
    private Date createTime;
}
