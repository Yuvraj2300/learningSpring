package com.lrn.spring.javaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource(value = "classpath:message.properties")
@ComponentScan(basePackages = "com.lrn.spring.*")
public class AppConfig {

	/*
	 * @Autowired Environment env;
	 */
	/*
	 * @Bean
	 * 
	 * @Lazy public MessageProvider messageProvider() { return new
	 * ConfigurableMessageProvider(); }
	 */
	@Autowired
	MessageProvider provider;

	@Bean(name = "messageRenderer")
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider);
		return renderer;
	}
}
