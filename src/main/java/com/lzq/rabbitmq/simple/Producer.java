package com.lzq.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args){
        //所有的中间件都是基于tcp/ip协议基础之上构建新的协议模板，rabbitmq遵循的是amqp
        //ip port

        //1：创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");

        Connection connection = null;
        Channel channel = null;
        try {
            //2：创建连接Connection
            connection = connectionFactory.newConnection("生产者");
            //3：通过连接获取通道Channel
            channel = connection.createChannel();
            //4：通过创建交换机，声明队列，绑定关系，路由key，发送消息和接收消息
            String queueName = "queue1";
            //queueDeclare(队列名称,是否持久化durable=false，排他性，是否独占独立，是否自动删除，携带附属参数);
            channel.queueDeclare(queueName,false,false,false,null);
            //5：准备消息内容
            String message = "Hello rabbitmq";
            //6：发送消息给队列queue
            channel.basicPublish("",queueName,null,message.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //7：关闭连接
            if(channel!=null&&channel.isOpen()){
                try {
                    channel.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            //8：关闭通道
            if(connection!=null&&connection.isOpen()){
                try {
                    connection.close();
                }catch (Exception ey){
                    ey.printStackTrace();
                }
            }
        }
    }
}