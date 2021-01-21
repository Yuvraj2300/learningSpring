package com.lrn.spring.tx.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.lrn.tx.spring" })
public class ServicesConfig {
	@Autowired
	@Qualifier("emf")
	EntityManagerFactory emf;

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(emf);
	}
}
