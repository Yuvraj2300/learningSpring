package com.lrn.spring.sch.service;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lrn.spring.sch.model.Car;

@Service("carScheduledService")
public class ScheduledCarServiceImple extends CarServiceImpl {
	@Override
	@Scheduled(fixedDelay = 10000)
	public void updateCarAgeJob() {
		List<Car> cars = findAll();
		DateTime currentDate = DateTime.now();
		logger.info("Car age update job started");
		cars.forEach(car -> {
			int age = Years.yearsBetween(car.getManufactureDate(), currentDate).getYears();
			car.setAge(age);
			save(car);
			logger.info("Car age update --> " + car);
		});
		logger.info("Car age update job completed successfully");
	}
}
