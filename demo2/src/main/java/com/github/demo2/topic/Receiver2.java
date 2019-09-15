package com.github.demo2.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname Receiver1
 * @Description TODO
 * @Date 2019/9/16 上午12:13
 * @Created by mahongtao
 */
@Component
@RabbitListener(queues = "q_topic_message")
public class Receiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }

}
