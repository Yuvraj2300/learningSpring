package com.lrn.spring.profiles.hs;

import java.util.ArrayList;
import java.util.List;

import com.lrn.spring.profiles.Food;
import com.lrn.spring.profiles.FoodProviderService;

public class FoodProviderImpl implements FoodProviderService {
	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<Food>();
		lunchSet.add(new Food("Coke"));
		lunchSet.add(new Food("Hamburger"));
		lunchSet.add(new Food("French Fries"));
		return lunchSet;
	}
}
