package com.yp.demo.rabbitmq.simple.comsumer;

import com.yp.demo.rabbitmq.config.MqConstants;
import com.yp.demo.rabbitmq.vo.MsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration
public class TopicConsumer {

    @RabbitHandler
    @RabbitListener(queues = MqConstants.Topic.TOPIC_QUEUE_NAME_A)
    public void consumerA(MsgVO msgVO){
        log.info("[TOPIC CONSUMER] queueA consumerA msg={}",msgVO);
    }

    @RabbitHandler
    @RabbitListener(queues = MqConstants.Topic.TOPIC_QUEUE_NAME_B)
    public void consumerWithN(MsgVO msgVO){
        log.info("[TOPIC CONSUMER] queueB consumerWithN msg={}",msgVO);
    }
}
