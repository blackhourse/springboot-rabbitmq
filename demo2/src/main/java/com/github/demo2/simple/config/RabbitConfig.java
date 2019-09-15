package com.github.demo2.simple.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Classname RabbitConfig
 * @Description mq配置类
 * @Date 2019/9/15 下午11:42
 * @Created by mahongtao
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("queue_hello");
    }

}
