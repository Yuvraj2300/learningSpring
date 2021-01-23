package com.lrn.spring.jpa.service;

import java.util.List;

import com.lrn.spring.jpa.entities.Album;
import com.lrn.spring.jpa.entities.Singer;

public interface AlbumService {
	List<Album> findByTitle(String title);

	List<Album> findBySinger(Singer singer);
}
