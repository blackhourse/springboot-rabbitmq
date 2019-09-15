package com.github.demo2.work;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname Consumer
 * @Description 消费者
 * @Date 2019/9/15 下午11:51
 * @Created by mahongtao
 */
@Component
@RabbitListener(queues = "queue_hello")
public class Consumer2 {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver2 " + hello);
    }


}
