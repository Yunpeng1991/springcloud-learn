package com.yp.demo.rabbitmq.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Properties;

@Configuration
public class RuntimeEnvConfig {

    private static final String S_FIX = "_";

    private final ApplicationContext applicationContext;

    public RuntimeEnvConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public final String getMqEnvSuffix(){
        String env = "";
        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        if(activeProfiles.length>0) {
            env = activeProfiles[0];
        }else {
            String[] defaultProfiles = applicationContext.getEnvironment().getDefaultProfiles();
            if(defaultProfiles.length>0){
                env = defaultProfiles[0];
            }
        }
        if(!"".equals(env)){
            env = S_FIX + env.toUpperCase();
        }

        return env;
    }

    @Bean("rabbitConfigProperties")
    public Properties rabbitConfigProperties(){
        Properties properties = new Properties();
        Arrays.asList(MqConstants.queueNames()).forEach(queueName->properties.setProperty(queueName,queueName+getMqEnvSuffix()));
        return properties;
    }
}
