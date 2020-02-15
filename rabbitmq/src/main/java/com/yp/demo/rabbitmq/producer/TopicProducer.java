package com.yp.demo.rabbitmq.producer;

import com.yp.demo.rabbitmq.config.MqConstants;
import com.yp.demo.rabbitmq.vo.MsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TopicProducer {

    private static final String OK = "OK";

    private final AmqpTemplate amqpTemplate;


    public TopicProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    /**
     * test topic
     * @param msgVO
     * @return
     */
    public String topicSendA(MsgVO msgVO){
        amqpTemplate.convertAndSend(MqConstants.Topic.TOPIC_EXCHANGE_NAME,MqConstants.Topic.TOPIC_ROUTE_KEY_A,msgVO);
        log.info("[TOPIC PRODUCER] topicSendA msg={}",msgVO);
        return OK;
    }

    public String topicSendB(MsgVO msgVO){
        amqpTemplate.convertAndSend(MqConstants.Topic.TOPIC_EXCHANGE_NAME,MqConstants.Topic.TOPIC_ROUTE_KEY_B,msgVO);
        log.info("[TOPIC PRODUCER] topicSendB msg={}",msgVO);
        return OK;
    }

    public String topicSendN(MsgVO msgVO){
        amqpTemplate.convertAndSend(MqConstants.Topic.TOPIC_EXCHANGE_NAME,MqConstants.Topic.TOPIC_ROUTE_KEY_N,msgVO);
        log.info("[TOPIC PRODUCER] topicSendB msg={}",msgVO);
        return OK;
    }
}
