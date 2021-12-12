package com.lzq.rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
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

            channel.basicConsume("queue1", true, new DeliverCallback() {
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println("收到的消息为：" + new String(delivery.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                public void handle(String s) throws IOException {
                    System.out.println("接收失败了");
                }
            });
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                channel.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            try {
                connection.close();
            }catch (Exception ey){
                ey.printStackTrace();
            }
        }
    }
}
