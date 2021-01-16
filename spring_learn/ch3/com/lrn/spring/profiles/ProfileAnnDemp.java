package com.lrn.spring.profiles;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lrn.spring.profiles.hs.HighSchoolConfig;
import com.lrn.spring.profiles.kg.KgConfig;

public class ProfileAnnDemp {
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(HighSchoolConfig.class, KgConfig.class);
		FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
		List<Food> lunchSet = foodProviderService.provideLunchSet();
		for (Food food : lunchSet) {
			System.out.println("Food: " + food.getName());
		}
		ctx.close();
	}
}
