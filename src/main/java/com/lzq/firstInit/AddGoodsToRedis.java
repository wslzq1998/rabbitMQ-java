package com.lzq.firstInit;


import com.lzq.model.Goods;
import com.lzq.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//初始化调用次序
@Order(1)
//项目启动后把数据加载到redis中
public class AddGoodsToRedis implements CommandLineRunner {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private GoodsService goodsService;

    private Logger logger = LoggerFactory.getLogger(AddGoodsToRedis.class);
    @Override
    public void run(String... args) throws Exception {
        List<Goods> goodsList = goodsService.selectGoods();
        for(Goods a:goodsList){
            redisTemplate.opsForValue().set(a.getGoodsId(),a.getGoodsCount());
            logger.info(redisTemplate.opsForValue().get(a.getGoodsId()).toString());
        }
    }
}
