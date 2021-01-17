package com.lrn.spring.hib.dao;

import java.util.List;

import com.lrn.spring.hib.entities.Singer;

public interface SingerDao {
	List<Singer> findAll();

	List<Singer> findAllWithAlbum();

	Singer findById(Long id);

	Singer save(Singer contact);

	void delete(Singer contact);
}
