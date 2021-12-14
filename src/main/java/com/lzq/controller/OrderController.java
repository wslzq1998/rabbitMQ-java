package com.lzq.controller;

import com.lzq.config.RabbitConfig;
import com.lzq.config.RabbitMQConfig;
import com.lzq.model.Order;
import com.lzq.service.GoodsService;
import com.lzq.service.OrderService;
import com.lzq.service.TransActionalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TransActionalService transActionalService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitConfig rabbitConfig;
    @Autowired
    private RabbitMQConfig rabbitMQConfig;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private Logger logger = LoggerFactory.getLogger(goodsController.class);

    @GetMapping("/insert/{userId}/{goodsId}")
    @ResponseBody
    public String buyGoods(@PathVariable("userId")String userId, @PathVariable("goodsId")String goodsId){
        Order order = new Order();
        order.setGoodsId(goodsId);
        order.setPayStatus("0");
        order.setUserId(userId);
        int insertCount = orderService.orderInsert(order);
        System.out.println(insertCount);
        return "生成订单成功";
    }
    @GetMapping("/orderSelect")
    @ResponseBody
    public List<Order> selectOrderList(){
        return orderService.selectOrder();
    }

    @GetMapping("/insert")
    @ResponseBody
    public String insertTransActionalTest(){
        transActionalService.goodsAndOrderInsert();
        return "success";
    }
    @GetMapping("/goodsInsert")
    @ResponseBody
    public String goodsInsertTransActionalTest(){
        transActionalService.goodsInsert();
        return "success";
    }
}
