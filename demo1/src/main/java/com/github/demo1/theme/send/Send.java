package com.github.demo1.theme.send;

import com.github.demo1.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Classname Send
 * @Description 主题模式-生产者
 * @Date 2019/9/15 下午10:20
 * @Created by mahongtao
 */
public class Send {

    public static final String EXCHANGE_NAME = "test_exchange_topic";


    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明 交换机  交换机名称、类型
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        // 消息内容
        String message = "hello,world";
        //
        channel.basicPublish(EXCHANGE_NAME, "routekey.1" ,null, message.getBytes());
        System.out.println(" [x]  [主题模式] Send '" + message + "");
        channel.close();
        connection.close();

    }


}
