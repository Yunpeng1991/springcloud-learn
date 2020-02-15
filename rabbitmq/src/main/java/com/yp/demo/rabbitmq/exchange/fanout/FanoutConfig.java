package com.yp.demo.rabbitmq.exchange.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean("fanout1")
    public Queue fanout1() {
        return new Queue("fanout1",true);  //true 是否持久
    }

    @Bean("fanout2")
    public Queue fanout2() {
        return new Queue("fanout2",true);  //true 是否持久
    }

    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean("fanoutBind")
    public Binding fanoutBind()  {
        return BindingBuilder.bind(fanout1()).to(fanoutExchange());
    }

    @Bean("fanoutBind2")
    public Binding fanoutBind2()  {
        return BindingBuilder.bind(fanout2()).to(fanoutExchange());
    }
}
