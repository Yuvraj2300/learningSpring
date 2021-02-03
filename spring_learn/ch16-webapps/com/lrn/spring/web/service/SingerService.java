package com.lrn.spring.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lrn.spring.web.entities.Singer;

public interface SingerService {
	List<Singer> findAll();

	Singer findById(Long id);

	Singer save(Singer singer);

	Page<Singer> findAllByPage(Pageable page);
}
