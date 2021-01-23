package com.lrn.spring.jpa.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lrn.spring.jpa.entities.Album;
import com.lrn.spring.jpa.entities.Singer;

public interface AlbumJPARep extends JpaRepository<Album, Long> {

	List<Album> findBySinger(Singer singer);

	@Query(value = "select a from Album a where a.title like '%:t%'")
	List<Album> findByTitle(@Param("t")String t);
}
