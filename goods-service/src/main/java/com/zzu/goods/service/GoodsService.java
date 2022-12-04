package com.zzu.goods.service;


import com.zzu.generalApi.vo.RespBean;
import com.zzu.goods.pojo.Goods;

import java.util.List;

public interface GoodsService {
    RespBean<List<Goods>> getAllGoods();
    RespBean<Goods> getGoodsById(Long goodsId);
}
