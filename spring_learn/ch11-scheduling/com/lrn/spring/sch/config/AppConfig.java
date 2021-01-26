package com.lrn.spring.sch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@Import({ DataServiceConfig.class })
//@ImportResource("classpath:task-namespace-app-context.xml")
@EnableScheduling
public class AppConfig {

	@Bean
	TaskScheduler carScheduler() {
		ThreadPoolTaskScheduler carScheduler = new ThreadPoolTaskScheduler();
		carScheduler.setPoolSize(10);
		return carScheduler;
	}

}
