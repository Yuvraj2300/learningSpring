package com.lrn.spring.rmt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.lrn.spring.rmt.services.SingerService;

@Configuration
public class HttpInvokerConfig {
	@Autowired
	SingerService singerService;

	@Bean(name = "/httpInvoker/singerService")
	public HttpInvokerServiceExporter httpInvokerServiceExporter() {
		HttpInvokerServiceExporter invokerService = new HttpInvokerServiceExporter();
		invokerService.setService(singerService);
		invokerService.setServiceInterface(SingerService.class);
		return invokerService;
	}
}
