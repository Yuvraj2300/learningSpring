package com.lrn.spring.hib.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lrn.spring.hib.entities.Singer;

@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {
	private static final Log logger = LogFactory.getLog(SingerDaoImpl.class);
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
	}

	@Override
	public List<Singer> findAllWithAlbum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Singer findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Singer save(Singer contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Singer contact) {
		// TODO Auto-generated method stub

	}

}
