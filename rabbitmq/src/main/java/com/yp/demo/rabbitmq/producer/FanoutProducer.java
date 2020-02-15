package com.yp.demo.rabbitmq.producer;

import com.yp.demo.rabbitmq.config.MqConstants;
import com.yp.demo.rabbitmq.vo.MsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FanoutProducer {

    private static final String OK = "OK";

    private AmqpTemplate amqpTemplate;

    public FanoutProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public String fanoutSender(MsgVO msgVO){
        //don`t need routeKey
        amqpTemplate.convertAndSend(MqConstants.Fanout.FANOUT_EXCHANGE_NAME,"",msgVO);
        log.info("[FANOUT PRODUCER] fanout send={}",msgVO);
        return OK;
    }

}
