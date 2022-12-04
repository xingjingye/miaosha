package com.zzu.goods.controller;

import com.zzu.generalApi.vo.RespBean;
import com.zzu.goods.pojo.Goods;
import com.zzu.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @program: seckill-demo01
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-17 19:51
 **/

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/all")
    public RespBean<List<Goods>> getAllGoods() {
        return goodsService.getAllGoods();
    }


    @GetMapping("/{goodsId}")
    public RespBean<Goods> getGoodsById(@PathVariable("goodsId") Long goodsId) {
        return goodsService.getGoodsById(goodsId);
    }
}
