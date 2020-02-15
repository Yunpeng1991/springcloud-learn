
package com.yp.demo.rabbitmq.simple.exchange.topic;

import com.yp.demo.rabbitmq.config.MqConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Bean("topicQueueA")
    public Queue topicQueueA() {
        return new Queue(MqConstants.Topic.TOPIC_QUEUE_NAME_A,true);  //true 是否持久
    }

    @Bean("topicQueueB")
    public Queue topicQueueB() {
        return new Queue(MqConstants.Topic.TOPIC_QUEUE_NAME_B,true);  //true 是否持久
    }

    @Bean("topicExchange")
    public TopicExchange topicExchange() {
        return new TopicExchange(MqConstants.Topic.TOPIC_EXCHANGE_NAME);
    }

    @Bean("topicBindA")
    public Binding topicBindA()  {
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with(MqConstants.Topic.TOPIC_BINDING_KEY_A);
    }
    @Bean("topicBindA_Prefix")
    public Binding topicBindA_Prefix()  {
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with(MqConstants.Topic.TOPIC_BINDING_KEY_A_PREFIX);
    }

    @Bean("topicBindN")
    public Binding topicBindN()  {
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with(MqConstants.Topic.TOPIC_BINDING_KEY_ALL);
    }

}

