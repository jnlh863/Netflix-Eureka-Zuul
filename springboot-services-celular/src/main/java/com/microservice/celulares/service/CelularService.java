package com.microservice.celulares.service;

import com.microservice.celulares.entity.Celular;

import java.util.List;


public interface CelularService {
	
	public List<Celular> findAll();
	
	public Celular findById(Long id);
	
	public void deleteById(Long id);
	
	public Celular save(Celular instance);
	
	public boolean existsById(Long id);
	
}
