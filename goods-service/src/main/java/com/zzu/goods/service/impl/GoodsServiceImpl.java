package com.zzu.goods.service.impl;

import com.zzu.generalApi.vo.RespBean;
import com.zzu.goods.dao.GoodsDao;
import com.zzu.goods.pojo.Goods;
import com.zzu.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-18 12:31
 **/

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public RespBean<List<Goods>> getAllGoods() {
        return RespBean.success(goodsDao.getAllGoods());
    }

    @Override
    public RespBean<Goods> getGoodsById(Long goodsId) {
        return RespBean.success(goodsDao.getGoodsById(goodsId));
    }
}
