package com.lrn.spring.tx.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lrn.spring.tx.entities.Singer;

@Repository
public interface SingerRepository extends CrudRepository<Singer, Long> {

}
