package com.github.demo1.simple.rece;

import com.github.demo1.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @Classname Recv1
 * @Description 消费者
 * @Date 2019/9/5 下午10:34
 * @Created by mahongtao
 */
public class Recv1 {

    private static final String QUEUE_NAME= "q_test_01";

    public static void main(String[] args) throws IOException, InterruptedException {

        // 获取连接
        Connection connection = ConnectionUtil.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }

    }

}
