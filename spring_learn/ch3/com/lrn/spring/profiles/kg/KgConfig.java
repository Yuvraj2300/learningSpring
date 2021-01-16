package com.lrn.spring.profiles.kg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lrn.spring.profiles.FoodProviderService;

@Configuration
@Profile("kg")
public class KgConfig {
	@Bean
	public FoodProviderService foodProviderService() {
		return new FoodProviderImpl();
	}
}
