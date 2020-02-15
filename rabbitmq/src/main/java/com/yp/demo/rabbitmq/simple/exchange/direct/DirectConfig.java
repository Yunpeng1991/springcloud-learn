package com.yp.demo.rabbitmq.simple.exchange.direct;

import com.yp.demo.rabbitmq.config.MqConstants;
import com.yp.demo.rabbitmq.config.RuntimeEnvConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    private final RuntimeEnvConfig envConfig;

    public DirectConfig(@Qualifier("runtimeEnvConfig")RuntimeEnvConfig envConfig) {
        this.envConfig = envConfig;
    }

    /*queue declare***/

    @Bean("directQueueA")
    public Queue directQueueA() {
        return new Queue(MqConstants.Direct.DIRECT_QUEUE_NAME_A+envConfig.getMqEnvSuffix(),true);  //true 是否持久
    }

    @Bean("directQueueB")
    public Queue directQueueB() {
        return new Queue(MqConstants.Direct.DIRECT_QUEUE_NAME_B+envConfig.getMqEnvSuffix(),true);  //true 是否持久
    }

    /*exchange declare***/

    @Bean("directExchange")
    public DirectExchange directExchange() {
        return new DirectExchange(MqConstants.Direct.DIRECT_EXCHANGE_NAME);
    }

    /*binding declare***/


    /*test fanout:相同exchangeType，相同RouteKey，不同queue实现类似广播的功能*/

    @Bean("bindingDirectA-fanout")
    public Binding bindingDirectAFanout()  {
        return BindingBuilder.bind(directQueueA()).to(directExchange()).with(MqConstants.Direct.DIRECT_ROUTE_KEY_A);
    }

    @Bean("bindingDirectB-fanout")
    public Binding bindingDirectBFanout()  {
        return BindingBuilder.bind(directQueueB()).to(directExchange()).with(MqConstants.Direct.DIRECT_ROUTE_KEY_A);
    }

    /*test p2p*/

    @Bean("bindingDirectBP2P")
    public Binding bindingDirectBP2P()  {
        return BindingBuilder.bind(directQueueB()).to(directExchange()).with(MqConstants.Direct.DIRECT_ROUTE_KEY_B);
    }

}
