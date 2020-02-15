package com.yp.demo.rabbitmq.simple.exchange.fanout;

import com.yp.demo.rabbitmq.config.MqConstants;
import com.yp.demo.rabbitmq.config.RuntimeEnvConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    private final RuntimeEnvConfig runtimeEnvConfig;

    public FanoutConfig(RuntimeEnvConfig runtimeEnvConfig) {
        this.runtimeEnvConfig = runtimeEnvConfig;
    }

    @Bean("fanoutQueueA")
    public Queue fanoutQueueA() {
        return new Queue(MqConstants.Fanout.FANOUT_QUEUE_NAME_A+runtimeEnvConfig.getMqEnvSuffix(),true);  //true 是否持久
    }

    @Bean("fanoutQueueB")
    public Queue fanoutQueueB() {
        return new Queue(MqConstants.Fanout.FANOUT_QUEUE_NAME_B+runtimeEnvConfig.getMqEnvSuffix(),true);  //true 是否持久
    }

    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(MqConstants.Fanout.FANOUT_EXCHANGE_NAME);
    }

    //don`t need routeKey

    @Bean("fanoutBindA")
    public Binding fanoutBindA()  {
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }

    @Bean("fanoutBindB")
    public Binding fanoutBindB()  {
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }
}
