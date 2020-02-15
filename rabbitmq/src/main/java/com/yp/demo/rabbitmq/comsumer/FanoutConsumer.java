package com.yp.demo.rabbitmq.comsumer;

import com.yp.demo.rabbitmq.config.MqConstants;
import com.yp.demo.rabbitmq.vo.MsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FanoutConsumer {
    /**
     * consumerFanout msg
     * @param msgVO must serializable
     */
    @RabbitHandler
    @RabbitListener(queues = {"#{rabbitConfigProperties.getProperty('"+ MqConstants.Fanout.FANOUT_QUEUE_NAME_A+"')}"})
    public void consumerFanoutA(MsgVO msgVO){
        log.info("[FANOUT CONSUMER] queueA fanoutA msg={}",msgVO);
    }

    @RabbitHandler
    @RabbitListener(queues = {"#{rabbitConfigProperties.getProperty('"+ MqConstants.Fanout.FANOUT_QUEUE_NAME_B+"')}"})
    public void consumerFanoutB(MsgVO msgVO){
        log.info("[FANOUT CONSUMER] queueB fanoutB msg={}",msgVO);
    }
}
