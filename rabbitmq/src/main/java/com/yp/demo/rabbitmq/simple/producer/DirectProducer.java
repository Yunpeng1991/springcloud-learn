package com.yp.demo.rabbitmq.simple.producer;

import com.yp.demo.rabbitmq.config.MqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DirectProducer {

    private static final String OK = "OK";

    private final AmqpTemplate amqpTemplate;

    public DirectProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public String testASender(String msg){
        amqpTemplate.convertAndSend(MqConstants.Direct.DIRECT_EXCHANGE_NAME,MqConstants.Direct.DIRECT_ROUTE_KEY_A,msg);
        log.info("[DIRECT PRODUCER] send A msg = {}",msg);
        return OK;
    }

    public String testBSender(String msg){
        amqpTemplate.convertAndSend(MqConstants.Direct.DIRECT_EXCHANGE_NAME,MqConstants.Direct.DIRECT_ROUTE_KEY_B,msg);
        log.info("[DIRECT PRODUCER] send B msg = {}",msg);
        return OK;
    }
}
