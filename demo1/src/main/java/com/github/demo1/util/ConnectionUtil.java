package com.github.demo1.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Classname ConnectionUtil
 * @Description  client连接
 * @Date 2019/9/5 下午10:17
 * @Created by mahongtao
 */
public class ConnectionUtil {

    /**
     * 获取连接
     * @return
     * @throws IOException
     */
    public static Connection getConnection() throws IOException {
        // 自定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置连接地址
        factory.setHost("localhost");
        // 设置端口号
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        return connection;

    }

}
