package com.github.demo1.route.consumer;

import com.github.demo1.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @Classname Recv1
 * @Description 消费者1    看作是搜索系统
 * @Date 2019/9/15 下午10:40
 * @Created by mahongtao
 */
public class Recv2 {

    private static final String QUEUE_NAME = "test_queue_direct2";

    private static final String EXCHANGE_NAME = "test_exchange_direct";



    public static final String ROUTE_KEY_DELETE = "delete";
    public static final String ROUTE_KEY_UPDATE = "update";
    public static final String ROUTE_KEY_INSERT = "insert";


    public static void main(String[] args) throws IOException, InterruptedException {

        Connection connection2 = ConnectionUtil.getConnection();
        Channel channel2 = connection2.createChannel();

        //声明队列
        channel2.queueDeclare(QUEUE_NAME, false, false, false, null);
        //将队列绑定到交换机上
//        channel2.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY_DELETE);
//        channel2.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY_UPDATE);
        channel2.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY_INSERT);

        // 同一时刻服务器只发一条消息给消费者
        channel2.basicQos(1);


        // 定义队列的消费者
        QueueingConsumer consumer2 = new QueueingConsumer(channel2);

        //监听队列 手动返回完成
        channel2.basicConsume(QUEUE_NAME,false,consumer2);

        // 获取消息
        while (true){
            QueueingConsumer.Delivery delivery2 = consumer2.nextDelivery();
            byte[] message = delivery2.getBody();
            System.out.println(" [Recv2] [路由模式] Received '" + message.toString() + "'");
            Thread.sleep(10);
            channel2.basicAck(delivery2.getEnvelope().getDeliveryTag(),false);


        }



    }

}
