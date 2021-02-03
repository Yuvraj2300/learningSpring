package com.lrn.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.lrn.spring.web.entities.Singer;
import com.lrn.spring.web.repo.SingerRepository;

@Service
@Repository
@Transactional
public class SingerServiceImp implements SingerService {

	SingerRepository singerRep;

	@Autowired
	public void setSingerRep(SingerRepository singerRep) {
		this.singerRep = singerRep;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAll() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(singerRep.findAll());
	}

	@Override
	public Singer findById(Long id) {
		// TODO Auto-generated method stub
		return singerRep.findById(id).get();
	}

	@Override
	public Singer save(Singer singer) {
		// TODO Auto-generated method stub
		return singerRep.save(singer);
	}

	@Override
	public Page<Singer> findAllByPage(Pageable page) {
		// TODO Auto-generated method stub
		return singerRep.findAll(page);
	}

}
