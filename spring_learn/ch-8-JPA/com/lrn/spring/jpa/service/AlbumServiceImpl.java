package com.lrn.spring.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrn.spring.jpa.entities.Album;
import com.lrn.spring.jpa.entities.Singer;
import com.lrn.spring.jpa.service.repository.AlbumJPARep;

@Service("springJpaAlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumJPARep albumRep;

	@Override
	public List<Album> findByTitle(String title) {
		// TODO Auto-generated method stub
		return albumRep.findByTitle(title);
	}

	@Override
	public List<Album> findBySinger(Singer singer) {
		// TODO Auto-generated method stub
		return albumRep.findBySinger(singer);
	}

}
