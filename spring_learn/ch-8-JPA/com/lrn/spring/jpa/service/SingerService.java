package com.lrn.spring.jpa.service;

import java.util.List;

import com.lrn.spring.jpa.entities.Singer;

public interface SingerService {
	List<Singer> findAll();

	List<Singer> findAllWithAlbum();

	List<Singer> findByFirstName(String firstName);

	List<Singer> findByFirstNameAndLastName(String firstName, String lastName);

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);

	List<Singer> findAllByNativeQuery();

	List<Singer> findByCriteriaQuery(String a, String b);
}
