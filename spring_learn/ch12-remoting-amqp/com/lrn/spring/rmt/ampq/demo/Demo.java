package com.lrn.spring.rmt.ampq.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lrn.spring.rmt.ampq.service.WeatherService;

public class Demo {
	private static Logger logger = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:amqp-rpc-app-context.xml");
		ctx.refresh();

		WeatherService weatherService = ctx.getBean(WeatherService.class);
		logger.info("Forecast for FL: " + weatherService.getForecast("FL"));
		logger.info("Forecast for MA: " + weatherService.getForecast("MA"));
		logger.info("Forecast for CA: " + weatherService.getForecast("CA"));
		ctx.close();
	}

}
