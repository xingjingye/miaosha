package com.zzu.goods.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-17 19:08
 **/

@Data
public class Goods {
    private Long goodsId;
    private String name;
    private BigDecimal price;
    private Long num;
}
