package com.lrn.spring.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		return em.createNamedQuery(Singer.FIND_ALL, Singer.class).getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Singer> findAllWithAlbum() {
		List<Singer> singers = em.createNamedQuery(Singer.FIND_ALL_WITH_ALBUM, Singer.class).getResultList();
		return singers;
	}

	@Transactional(readOnly = true)
	@Override
	public Singer findById(Long id) {
		TypedQuery<Singer> q = em.createNamedQuery(Singer.FIND_SINGER_BY_ID, Singer.class).setParameter("id", id);
		return q.getSingleResult();
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
