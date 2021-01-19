package com.lrn.spring.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrn.spring.jpa.entities.Singer;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {
	final static String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

	private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<Singer> findAll() {
		throw new NotImplementedException("findAll");
	}

	@Transactional(readOnly = true)
	@Override
	public List<Singer> findAllWithAlbum() {
		throw new NotImplementedException("findAllWithAlbum");
	}

	@Transactional(readOnly = true)
	@Override
	public Singer findById(Long id) {
		throw new NotImplementedException("findById");
	}

	@Override
	public Singer save(Singer singer) {
		throw new NotImplementedException("save");
	}

	@Override
	public void delete(Singer singer) {
		throw new NotImplementedException("delete");

	}

	@Transactional(readOnly = true)
	@Override
	public List<Singer> findAllByNativeQuery() {
		throw new NotImplementedException("findAllByNativeQuery");
	}

}
