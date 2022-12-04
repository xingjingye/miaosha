package com.zzu.seckill.client;

import com.zzu.generalApi.vo.RespBean;
import com.zzu.seckill.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("goodsservice")
public interface GoodsClient {
    @GetMapping("/goods/{goodsId}")
    RespBean<Goods> getGoodsById(@PathVariable("goodsId") Long goodsId);

    @GetMapping("/goods/all")
    RespBean<List<Goods>> getAllGoods();
}
