package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzq.config.RabbitConfig;
import com.lzq.config.RabbitMQConfig;
import com.lzq.model.Goods;
import com.lzq.model.Order;
import com.lzq.rabbitmq.MsgProducer;
import com.lzq.service.GoodsService;
import com.lzq.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.lzq.config.RabbitMQConfig.*;

@Controller
public class goodsController{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitConfig rabbitConfig;
    @Autowired
    private RabbitMQConfig rabbitMQConfig;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private Logger logger = LoggerFactory.getLogger(goodsController.class);

    @RequestMapping("/goods")
    @ResponseBody
    public List<Goods> selectAll(){
        return goodsService.selectGoods();
    }

    @GetMapping("/rabbit/{id}")
    @ResponseBody
    public  String send(@PathVariable("id")Integer id) throws Exception{
        return goodsService.secKillGoods(id);
    }

    @GetMapping("/rabbit/message/{str}")
    @ResponseBody
    public  String sendMessage(@PathVariable("str")String str){
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            //设置编码
            messageProperties.setContentEncoding("utf-8");
            //设置过期时间60*1000毫秒
            messageProperties.setExpiration("60*1000");
            //设置全局唯一ID
            messageProperties.setCorrelationId(UUID.randomUUID().toString());
            return message;
        };
        rabbitTemplate.convertAndSend(BUSINESS_EXCHANGE_NAME,BUSINESS_QUEUEB_ROUTING_KEY, JSON.toJSONString(str+"QUEUEB"),messagePostProcessor);
        return "发送成功";
    }

}
