package com.lrn.spring.sch.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.sch.config.AppConfig;
import com.lrn.spring.sch.service.CarService;
import com.lrn.spring.sch.service.ScheduledCarServiceImple;

public class ScheduledTaskAnnoDemo {
	final static Logger logger = LoggerFactory.getLogger(ScheduledTaskAnnoDemo.class);

	public static void main(String[] args) throws Exception {

		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		CarService carService = (CarService) ctx.getBean("carScheduledService", ScheduledCarServiceImple.class);

		/*while (!carService.isDone()) {
			logger.info("Waiting for scheduled job to end ...");
			Thread.sleep(250);
		}*/
		System.in.read();
		ctx.close();

	}
}
