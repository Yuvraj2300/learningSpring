package com.lrn.spring.rmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.lrn.spring.rmt.services.SingerService;

@Configuration
public class RmiClientConfig {

	@Bean
	public SingerService singerService() {
		HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
		factoryBean.setServiceInterface(SingerService.class);
		factoryBean.setServiceUrl("");
		factoryBean.afterPropertiesSet();
		return (SingerService) factoryBean.getObject();
	}

}
