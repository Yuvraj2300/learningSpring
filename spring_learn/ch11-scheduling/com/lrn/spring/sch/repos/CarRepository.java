package com.lrn.spring.sch.repos;

import org.springframework.data.repository.CrudRepository;

import com.lrn.spring.sch.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

}
