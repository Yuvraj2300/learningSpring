package com.lrn.spring.tx.service;

import java.util.ArrayList;
import java.util.List;

import com.lrn.spring.tx.entities.Singer;

public interface SingerService {
	ArrayList<Singer> findAll();

	Singer findById(Long id);

	Singer save(Singer singer);

	Long countSingers();

}
