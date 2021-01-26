package com.lrn.spring.sch.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.sch.config.AppConfig;
import com.lrn.spring.sch.service.CarService;

public class Demo {
	final static Logger logger = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) throws InterruptedException, IOException {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		CarService carService = ctx.getBean("carService", CarService.class);

		while (!carService.isDone()) {
			logger.info("Waiting for scheduled job to end ...");
			Thread.sleep(250);
		}
		System.in.read();

		ctx.close();
	}
}
