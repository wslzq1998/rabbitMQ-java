package com.lzq.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.lzq.dao.OrderDao;
import com.lzq.model.Order;
import com.lzq.service.OrderService;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.lzq.config.RabbitMQConfig.BUSINESS_EXCHANGE_NAME;
import static com.lzq.config.RabbitMQConfig.BUSINESS_QUEUEB_ROUTING_KEY;

@Service(value = "OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public int updateOrderStatus(String orderId, String payStatus) {
        return orderDao.updateOrderStatus(orderId,payStatus);
    }

    @Override
    public int orderInsert(Order order){
//        MessagePostProcessor messagePostProcessor = message -> {
//            MessageProperties messageProperties = message.getMessageProperties();
//            //设置编码
//            messageProperties.setContentEncoding("utf-8");
//            //设置过期时间10*1000毫秒
//            messageProperties.setExpiration("30000");
//            //设置全局唯一ID
//            messageProperties.setCorrelationId(UUID.randomUUID().toString());
//            return message;
//        };
//        int count = orderDao.orderInsert(order);
//        rabbitTemplate.convertAndSend(BUSINESS_EXCHANGE_NAME,BUSINESS_QUEUEB_ROUTING_KEY, JSON.toJSONString(order),messagePostProcessor);
//
          int count = orderDao.orderInsert(order);
        return count;
    }

    @Override
    public List<Order> selectOrder() {
        return orderDao.selectOrder();
    }
}
