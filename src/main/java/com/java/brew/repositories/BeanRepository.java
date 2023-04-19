package com.java.brew.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.java.brew.models.Bean;


public interface BeanRepository extends CrudRepository<Bean, Long>{
	List<Bean> findAll();
}
