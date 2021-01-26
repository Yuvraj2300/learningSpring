package com.lrn.spring.rmt.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lrn.spring.rmt.entities.Singer;

public interface SingerRepository extends CrudRepository<Singer, Long> {
	List<Singer> findByFirstName(String firstName);
}
