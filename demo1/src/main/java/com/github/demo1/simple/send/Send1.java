package com.github.demo1.simple.send;

import com.github.demo1.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Classname Send1
 * @Description 生产者
 * @Date 2019/9/5 下午10:22
 * @Created by mahongtao
 */
public class Send1 {

    private static final String QUEUE_NAME= "q_test_01";

    public static void main(String[] args) throws IOException {

        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        //创建队列

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "hello,world";
        // 通过pushblish 方式 发送
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();


    }

}
