package com.lrn.spring.lifecycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

@Configuration
public class SingerConfig {
	@Lazy
	@Bean(initMethod = "init")
	Singer singerOne() {
		Singer singerOne = new Singer();
		singerOne.setAge(72);
		singerOne.setName("John Mayer");
		return singerOne;
	}

	@Lazy
	@Bean(initMethod = "init")
	Singer singerTwo() {
		Singer singerTwo = new Singer();
		singerTwo.setAge(80);
		return singerTwo;
	}

	@Lazy
	@Bean(initMethod = "init")
	Singer singerThree() {
		Singer singerthree = new Singer();
		singerthree.setName("Drake");
		singerthree.setAge(32);
		return singerthree;
	}

	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);
		getBean("singerOne", ctx);
		getBean("singerTwo", ctx);
		getBean("singerThree", ctx);

		ctx.close();
	}

	public static Singer getBean(String beanName, ApplicationContext ctx) {
		try {
			Singer bean = (Singer) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch (BeanCreationException ex) {
			System.out.println("An error occured in bean configuration: " + ex.getMessage());
			return null;
		}
	}

}
