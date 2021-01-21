package com.lrn.tx.spring.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.lrn.tx.spring.entities.Singer;
import com.lrn.tx.spring.repos.SingerRepository;

@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {
	final static String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

	private SingerRepository singerRep;

	@Autowired
	public void setSingerRepository(SingerRepository singerRepository) {
		this.singerRep = singerRepository;
	}

	private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

	@Override
	@Transactional(readOnly = true)
	public ArrayList<Singer> findAll() {
		return Lists.newArrayList(singerRep.findAll());
	}

}
