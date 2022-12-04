# miaosha
分布式秒杀项目



springboot + mybatis + mysql + redis + rabbitmq + springcloud(nacos + openfeign + gateway + ribbon)

1.采用分布式架构

2.统一异常处理

3.单点登录（redis + session方案，对密码进行md5加密）

4.解决超卖问题（update语句解决超卖问题，使用redis预减库存，减少对数据库的访问）

5.使用rabbitmq对秒杀消息进行异步处理，流量削峰
