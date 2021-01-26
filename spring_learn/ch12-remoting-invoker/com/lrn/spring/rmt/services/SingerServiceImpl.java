package com.lrn.spring.rmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrn.spring.rmt.entities.Singer;
import com.lrn.spring.rmt.repo.SingerRepository;

@Service
@Transactional
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerRepository singerRepository;

	@Override
	public List<Singer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Singer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Singer findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Singer save(Singer singer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Singer singer) {
		// TODO Auto-generated method stub

	}

}
