package com.yp.demo.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

//import org.springframework.boot.autoconfigure.amqp.RetryTemplateFactory;

@Slf4j(topic = "RabbitMqTemplate")
@Configuration
public class RabbitMqTemplate {

    @Bean
    public RabbitTemplate rabbitTemplate(RabbitProperties properties,
                                             ObjectProvider<MessageConverter> messageConverter,
                                             ObjectProvider<RabbitRetryTemplateCustomizer> retryTemplateCustomizers,
                                             ConnectionFactory connectionFactory){
        PropertyMapper map = PropertyMapper.get();
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        messageConverter.ifUnique(template::setMessageConverter);
        template.setMandatory(Boolean.TRUE);
        RabbitProperties.Template templateProperties = properties.getTemplate();
       template.setConfirmCallback((correlationData, ack, cause) -> log.info("ack info = {}, message info = {}, errorMsg = {} ",ack,correlationData,cause));
       template.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> log.info("exchange info = {}, routeKey info = {} , replyCode = {} , replyText = {} ,message info = {} ",exchange,routingKey,replyCode,replyText,message));
        map.from(templateProperties::getReceiveTimeout).whenNonNull().as(Duration::toMillis)
                .to(template::setReceiveTimeout);
        map.from(templateProperties::getReplyTimeout).whenNonNull().as(Duration::toMillis)
                .to(template::setReplyTimeout);
        map.from(templateProperties::getExchange).to(template::setExchange);
        map.from(templateProperties::getRoutingKey).to(template::setRoutingKey);
        map.from(templateProperties::getDefaultReceiveQueue).whenNonNull().to(template::setDefaultReceiveQueue);
        return template;
    }
}
