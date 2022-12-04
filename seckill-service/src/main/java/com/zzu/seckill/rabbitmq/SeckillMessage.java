package com.zzu.seckill.rabbitmq;

import com.zzu.generalApi.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: seckill-demo02
 * @description:
 * @author: XingJingYe
 * @create: 2022-11-26 09:17
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillMessage {

    private Long goodsId;
    private User user;
}
