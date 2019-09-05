package com.github.demo1.work.send;

import com.github.demo1.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Classname Send
 * @Description 生产者
 * @Date 2019/9/5 下午10:54
 * @Created by mahongtao
 */
public class Send {


    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 100; i++) {
            // 消息内容
            String message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);

        }
        channel.close();
        connection.close();
    }
}
