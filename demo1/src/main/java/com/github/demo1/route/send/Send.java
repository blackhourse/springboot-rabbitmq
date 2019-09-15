package com.github.demo1.route.send;

import com.github.demo1.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Classname Send
 * @Description 生产者
 * @Date 2019/9/15 下午10:20
 * @Created by mahongtao
 */
public class Send {

    public static final String EXCHANGE_NAME = "test_exchange_direct";
    public static final String ROUTE_KEY_DELETE = "delete";


    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明 交换机  交换机名称、类型
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        // 消息内容
        String message = "delete";
        //
        channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY_DELETE ,null, message.getBytes());
        System.out.println(" [x]  [路由模式] Send '" + message + "");
        channel.close();
        connection.close();

    }


}
