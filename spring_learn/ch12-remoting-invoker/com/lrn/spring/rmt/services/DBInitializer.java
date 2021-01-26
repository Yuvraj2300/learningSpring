package com.lrn.spring.rmt.services;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrn.spring.rmt.repo.SingerRepository;

@Service
public class DBInitializer {
	private Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	@Autowired
	SingerRepository singerRepository;

	@PostConstruct
	public void initDB() {
	}
}
