package com.zzu.order.dao;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Date;


@Mapper
public interface OrderDao {

    Boolean insertOrder(Long userId, Long goodsId, String goodsName, BigDecimal goodsPrice, Integer goodsNum,
                        String address, Date createTime);
}
