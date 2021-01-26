package com.lrn.spring.sch.service;

import java.util.List;

import com.lrn.spring.sch.model.Car;

public interface CarService {
	List<Car> findAll();

	Car save(Car car);

	void updateCarAgeJob();

	boolean isDone();
}