package com.yp.demo.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import java.util.Collections;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        final SpringApplication springApplication = new SpringApplication(JpaApplication.class);
        springApplication.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "local"));
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }

}
