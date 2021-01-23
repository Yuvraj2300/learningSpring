package com.lrn.spring.jpa.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.lrn.spring.jpa.entities.Singer;

public interface SingerRepository extends CrudRepository<Singer, Long> {
	List<Singer> findByFirstName(String name);

	List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
