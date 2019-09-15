package com.github.demo2.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname TopicRabbitConfig
 * @Description TODO
 * @Date 2019/9/16 上午12:09
 * @Created by mahongtao
 */
@Configuration
public class TopicRabbitConfig {

    final static String message = "q_topic_message";
    final static String messages = "q_topic_messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }
    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    /**
     * 声明一个Topic类型的交换机
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("mybootexchange");
    }

    /**
     * 绑定Q到交换机,并且指定routingKey
     * @param queueMessage
     * @param exchange
     * @return
     */
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with(message);
    }

    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }


}
