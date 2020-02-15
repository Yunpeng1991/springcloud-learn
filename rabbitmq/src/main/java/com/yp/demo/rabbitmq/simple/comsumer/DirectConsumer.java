package com.yp.demo.rabbitmq.simple.comsumer;

import com.yp.demo.rabbitmq.config.MqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DirectConsumer {

    /*test fanout:相同RouteKey，不同queue实现类相同exchangeType，似广播的功能*/

    @RabbitHandler
    @RabbitListener( queues = {"#{rabbitConfigProperties.getProperty('"+MqConstants.Direct.DIRECT_QUEUE_NAME_A+"')}"})
    public void  consumerP2P(String msg){
        log.info("[DIRECT CONSUMER] queueA test A, msg={}",msg);
    }

    /*test P2P*/
    @RabbitHandler
    @RabbitListener( queues = {"#{rabbitConfigProperties.getProperty('"+MqConstants.Direct.DIRECT_QUEUE_NAME_B+"')}"})
    public void  consumerRandom(String msg){
        log.info("[DIRECT CONSUMER] queueB test B, msg={}",msg);
    }



}
