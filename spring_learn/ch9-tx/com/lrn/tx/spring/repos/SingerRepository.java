package com.lrn.tx.spring.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lrn.tx.spring.entities.Singer;

@Repository
public interface SingerRepository extends CrudRepository<Singer, Long> {

}
