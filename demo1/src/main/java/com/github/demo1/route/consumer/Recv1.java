package com.github.demo1.route.consumer;

import com.github.demo1.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @Classname Recv1
 * @Description 消费者1    看作是前台系统
 * @Date 2019/9/15 下午10:40
 * @Created by mahongtao
 */
public class Recv1 {

    private static final String QUEUE_NAME = "test_queue_direct1";

    private static final String EXCHANGE_NAME = "test_exchange_direct";

    public static final String ROUTE_KEY_DELETE = "delete";
    public static final String ROUTE_KEY_UPDATE = "update";


    public static void main(String[] args) throws IOException, InterruptedException {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //将队列绑定到交换机上
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY_DELETE);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY_UPDATE);

        // 同一时刻服务器只发一条消息给消费者
        channel.basicQos(1);


        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //监听队列 手动返回完成
        channel.basicConsume(QUEUE_NAME,false,consumer);

        // 获取消息
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] message = delivery.getBody();
            System.out.println(" [Recv1] Received '" + message.toString() + "'");
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);


        }



    }

}
