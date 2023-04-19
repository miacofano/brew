package com.java.brew.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.brew.models.Bean;
import com.java.brew.repositories.BeanRepository;


@Service
public class BeanService {

	@Autowired
	private BeanRepository beanRepo;
	
	//FIND OBJECT BY ID
	public Bean findById(Long id) {
		Optional<Bean> result = beanRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	//FIND ALL OBJECTS
	public List<Bean> all() {
		return beanRepo.findAll();
	}
	
	//CREATE OBJECT
	public Bean create(Bean bean) {
		return beanRepo.save(bean);
	}
	
	//DELETE OBJECT
	public void delete(Bean bean) {
		beanRepo.delete(bean);
	}
	
	//UPDATE OBJECT
	public Bean update(Bean bean) {
		return beanRepo.save(bean);
	}
}
