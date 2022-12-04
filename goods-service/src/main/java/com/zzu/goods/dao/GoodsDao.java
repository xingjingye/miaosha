package com.zzu.goods.dao;

import com.zzu.goods.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface GoodsDao {
    List<Goods> getAllGoods();
    Goods getGoodsById(Long goodsId);
}
