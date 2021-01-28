package com.lrn.spring.rmt.jms.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.rmt.jms.config.AppConfig;
import com.lrn.spring.rmt.jms.sender.MessageSender;


public class JmsHornetQSample {
	public static void main(String[] args) throws Exception {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageSender sender = ctx.getBean("messageSender", MessageSender.class);
		for (int i = 0; i < 5; i++) {
			sender.sendMessage("[MSG]::---- Message # " + i);
		}

		System.in.read();
		ctx.close();
	}
}
