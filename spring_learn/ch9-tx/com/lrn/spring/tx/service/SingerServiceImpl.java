package com.lrn.spring.tx.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.lrn.spring.tx.entities.Singer;
import com.lrn.spring.tx.repos.SingerRepository;

@Service("singerService")
@Transactional
@Repository
public class SingerServiceImpl implements SingerService {
	final static String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

//	private SingerRepository singerRep;

	@PersistenceContext(unitName = "emfA")
	private EntityManager emA;

	@PersistenceContext(unitName = "emfB")
	private EntityManager emB;

	/*
	 * @Autowired public void setSingerRepository(SingerRepository singerRepository)
	 * { this.singerRep = singerRepository; }
	 * 
	 */	private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

	@Override
	@Transactional(readOnly = true)
	public ArrayList<Singer> findAll() {
//		return Lists.newArrayList(singerRep.findAll());
	return null;
	}

	@Override
//	@Transactional(readOnly = true)
	public Singer save(Singer singer) {
//		return singerRep.save(singer);
		Singer singerB = new Singer();
		singerB.setFirstName(singer.getFirstName());
		singerB.setLastName(singer.getLastName());
		if (singer.getId() == null) {
			emA.persist(singer);
			emB.persist(singerB);
		} else {
			emA.merge(singer);
			emB.merge(singerB);
		}
		return singer;
	}

	@Override
	public Singer findById(Long id) {
//		Optional<Singer> singerOp = singerRep.findById(id);
//		return singerOp.get();
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public Long countSingers() {
		// TODO Auto-generated method stub
//		return singerRep.countSingers();
		return null;
	}

}
