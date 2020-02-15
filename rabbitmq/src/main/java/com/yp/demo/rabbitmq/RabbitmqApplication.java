package com.yp.demo.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import java.util.Collections;

@SpringBootApplication
public class RabbitmqApplication {

	public static void main(String[] args) {
		final SpringApplication springApplication = new SpringApplication(RabbitmqApplication.class);
		springApplication.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "local"));
		springApplication.addListeners(new ApplicationPidFileWriter());
		springApplication.run(args);
	}

}
