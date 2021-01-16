package com.lrn.spring.profiles.kg;

import java.util.ArrayList;
import java.util.List;

import com.lrn.spring.profiles.Food;
import com.lrn.spring.profiles.FoodProviderService;

public class FoodProviderImpl implements FoodProviderService {
	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<>();
		lunchSet.add(new Food("Milk"));
		lunchSet.add(new Food("Biscuits"));
		return lunchSet;
	}
}
