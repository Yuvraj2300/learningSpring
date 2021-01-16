package com.lrn.spring.profiles.hs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lrn.spring.profiles.FoodProviderService;

@Configuration
@Profile("hs")
public class HighSchoolConfig {
	@Bean
	public FoodProviderService foodproviderService() {
		return new FoodProviderImpl();
	}
}
