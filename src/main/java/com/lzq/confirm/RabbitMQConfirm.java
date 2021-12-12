package com.lzq.confirm;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQConfirm implements RabbitTemplate.ConfirmCallback {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    //通过实现 ConfirmCallback 接口，消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("回调ID为:"+correlationData.getId());
        if(b){
            logger.info("生产者0被消息成功消费");
        }else{
            logger.info("生产者0被消息消费失败:" + s );
        }
    }
}
