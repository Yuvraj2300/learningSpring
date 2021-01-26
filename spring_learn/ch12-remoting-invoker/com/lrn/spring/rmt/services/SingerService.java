package com.lrn.spring.rmt.services;

import java.util.List;

import com.lrn.spring.rmt.entities.Singer;

public interface SingerService {

	List<Singer> findAll();

	List<Singer> findByFirstName(String firstName);

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);

}
