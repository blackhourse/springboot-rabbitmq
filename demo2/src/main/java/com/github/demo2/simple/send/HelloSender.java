package com.github.demo2.simple.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname HelloSender
 * @Description TODO
 * @Date 2019/9/15 下午11:46
 * @Created by mahongtao
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        //24小时制
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String msg = "hello," + date;
        System.out.println("Sender : " + msg);
        //简单对列的情况下routingKey即为Q名
        amqpTemplate.convertAndSend("queue_hello",msg);

    }



}
