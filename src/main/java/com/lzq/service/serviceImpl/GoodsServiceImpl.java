package com.lzq.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.lzq.config.RabbitConfig;
import com.lzq.dao.GoodsDao;
import com.lzq.model.Goods;
import com.lzq.rabbitmq.MsgProducer;
import com.lzq.service.GoodsService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static com.lzq.config.RabbitMQConfig.BUSINESS_EXCHANGE_NAME;
import static com.lzq.config.RabbitMQConfig.BUSINESS_QUEUEA_ROUTING_KEY;

@Service(value = "GoodsService")
public class GoodsServiceImpl implements GoodsService, Serializable {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitConfig rabbitConfig;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> selectGoods() {
        return goodsDao.selectGoods();
    }

    @Override
    public int updateGoods(Integer id) {
        System.out.println("传入的参数："+id);
        return goodsDao.updateGoods(id);
    }

    public String secKillGoods(Integer id){
        System.out.println(redisTemplate.opsForValue().get("1"));
        Integer count = Integer.valueOf(redisTemplate.opsForValue().get(id.toString()).toString());
        if(count == 0){
            return "没库存了";
        }
        //库存大于1，可以进行购买
        if(count > 0 ){
            count = Integer.valueOf(redisTemplate.opsForValue().get(id.toString()).toString());
            redisTemplate.opsForValue().set(id.toString(),""+(count-1));
            System.out.println("redis库存剩余:"+ redisTemplate.opsForValue().get(id.toString()));
            //发送到rabiitMQ的队列中
            rabbitTemplate.convertAndSend(
                    BUSINESS_EXCHANGE_NAME,
                    BUSINESS_QUEUEA_ROUTING_KEY,
                    JSON.toJSONString(id),
                    new MessagePostProcessor() {
                        @Override
                        public Message postProcessMessage(Message message) throws AmqpException {
                            MessageProperties messageProperties = message.getMessageProperties();
                            //编码
                            messageProperties.setContentEncoding("utf-8");
                            //过期时间
                            messageProperties.setExpiration("10000");
                            //设置全局唯一ID，保证生产者不会重复生产消息
                            messageProperties.setMessageId(UUID.randomUUID()+"");
                            return message;
                        }
                    });
            return "购买成功";
        }
        return "error";
    }
}
