package com.lrn.spring.profiles;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runner {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:*profile-config.xml");
		ctx.refresh();
		FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
		List<Food> lunchSet = foodProviderService.provideLunchSet();
		for (Food food : lunchSet) {
			System.out.println("Food: " + food.getName());
		}
		ctx.close();
	}
}
