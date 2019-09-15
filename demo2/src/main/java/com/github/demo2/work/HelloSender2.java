package com.github.demo2.work;

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
public class HelloSender2 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello " + i + " " + date;
        System.out.println("Sender2 : " + context);
        //简单对列的情况下routingKey即为Q名
        this.amqpTemplate.convertAndSend("queue_hello", context);
    }


}
