package com.lzq.rabbitmq;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzq.config.RabbitConfig;
import com.lzq.model.Goods;
import com.lzq.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private GoodsService goodsService;
    //   @RabbitHandler
//    public void process(String content) {
//       logger.info("处理器one接收处理队列A当中的消息：" +content);
//   }

    @RabbitHandler
    public void process(Map mp){
        List<Goods> goodsList = goodsService.selectGoods();
        Map hashMap = new HashMap<String,Integer>();
        for(Goods a:goodsList){
            hashMap.put(a.getGoodsId(),a.getGoodsCount());
        }
        Integer allCount = Integer.valueOf(hashMap.get("1").toString());

        String goodsId = (String) mp.get("goodsId");
        Integer reduce = (Integer) mp.get("reduce");
        System.out.println("更新成的件数"+String.valueOf(allCount-reduce));
        int successFlag =  goodsService.updateGoods(1);
        System.out.println(successFlag+"更新成功");

    }
}
