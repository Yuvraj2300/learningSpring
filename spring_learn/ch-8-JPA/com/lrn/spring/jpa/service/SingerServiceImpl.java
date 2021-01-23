package com.lrn.spring.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.lrn.spring.jpa.entities.Singer;
import com.lrn.spring.jpa.entities.Singer_;
import com.lrn.spring.jpa.service.repository.SingerRepository;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {
	final static String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

	private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

	@Autowired
	private SingerRepository singerRep;

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<Singer> findAll() {
//		return em.createNamedQuery(Singer.FIND_ALL, Singer.class).getResultList();
		// return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY,
		// "singerResult").getResultList();
		return Lists.newArrayList(singerRep.findAll());
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

	@Override
	public List<Singer> findByCriteriaQuery(String firstName, String lastName) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Singer> criteriaQuery = cb.createQuery(Singer.class);
		Root<Singer> root = criteriaQuery.from(Singer.class);
		root.fetch(Singer_.albums, JoinType.LEFT);
		root.fetch(Singer_.instruments, JoinType.LEFT);

		criteriaQuery.select(root).distinct(true);

		Predicate criteria = cb.conjunction();

		if (firstName != null) {
			Predicate p = cb.equal(root.get(Singer_.firstName), firstName);
			criteria = cb.and(criteria, p);
		}

		if (lastName != null) {
			Predicate p = cb.equal(root.get(Singer_.lastName), lastName);
			criteria = cb.and(criteria, p);
		}

		criteriaQuery.where(criteria);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return singerRep.findByFirstName(firstName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return singerRep.findByFirstNameAndLastName(firstName, lastName);
	}

}
