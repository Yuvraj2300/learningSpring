package com.lrn.spring.rmt.ampq.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.rmt.ampq.config.RabbitMQConfig;

public class JavaConfigDemo {
	public static void main(String... args) throws Exception {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
		RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);
		rabbitTemplate.convertAndSend("FL");
		rabbitTemplate.convertAndSend("MA");
		rabbitTemplate.convertAndSend("CA");
		System.in.read();
		ctx.close();
	}
}
