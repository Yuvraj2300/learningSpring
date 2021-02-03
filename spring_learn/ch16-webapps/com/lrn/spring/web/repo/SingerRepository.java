package com.lrn.spring.web.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lrn.spring.web.entities.Singer;

public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {

}
