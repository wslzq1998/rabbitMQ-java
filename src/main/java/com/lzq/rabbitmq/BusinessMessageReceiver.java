package com.lzq.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.model.Order;
import com.lzq.service.GoodsService;
import com.lzq.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

import static com.lzq.config.RabbitMQConfig.*;

@Slf4j
@Component
public class BusinessMessageReceiver{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = BUSINESS_QUEUEA_NAME)
    public void receiveA(Message message, Channel channel) throws IOException {
        System.out.println("QueueA监听中。。。。。");
        System.out.println(new String(message.getBody()));
        try{
            goodsService.updateGoods(Integer.valueOf(new String(message.getBody())));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("QueueA消费成功。。。。。");
        }catch (Exception e){
            logger.info("出现错误，写入死信队列。。。。");
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        }
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
    }
    @RabbitListener(queues = DEAD_LETTER_QUEUEA_NAME)
    public void receiveDeadLetterA(Message message,Channel channel) throws IOException {
        System.out.println("死信QueueA监听中。。。。。");
        System.out.println(new String(message.getBody()));

        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
//    @RabbitListener(queues = BUSINESS_QUEUEB_NAME)
    //延时业务队列
    public void receiveB(Message message,Channel channel) throws IOException {
        System.out.println("QueueB监听中。。。。。");
        System.out.println(new String(message.getBody()));
        System.out.println(message.getMessageProperties().getCorrelationId());
        JSONObject json = JSON.parseObject(new String(message.getBody()));
        String str = json.toJSONString();
        Order order = JSON.parseObject(str,Order.class);
        //生成订单
//        int insertCount = orderService.orderInsert(order);
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
    @RabbitListener(queues = DEAD_LETTER_QUEUEB_NAME)
    public void receiveDeadLetterB(Message message,Channel channel) throws IOException {
        System.out.println("死信QueueB监听中。。。。。");
        System.out.println(new String(message.getBody()));
        try {
            JSONObject json = JSON.parseObject(new String(message.getBody()));
            String str = json.toJSONString();
            Order order = JSON.parseObject(str,Order.class);
            System.out.println("订单过期,修改订单状态。。。。");
            orderService.updateOrderStatus(order.getOrderId(),"2");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("订单过期,修改订单状态失败。。。。");
        }
        System.out.println("订单过期,修改订单状态成功。。。。");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
