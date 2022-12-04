package com.zzu.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-19 20:57
 **/
@Data
public class OrderVO {

    private Long userId;
    private Long goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private int goodsNum;
    private String address;
    private Date createTime;
}
