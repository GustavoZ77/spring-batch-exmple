package com.w2o.batchpoc.service;

import java.util.List;

import com.w2o.batchpoc.domain.Empleo;
import com.w2o.batchpoc.repository.EmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleoService {

	@Autowired
	private EmpleoRepository repository;
	
	public List<Empleo> findEmpleoByCategory(Long category) {
		List<Empleo> empleos = repository.findEmpleosByEmpleo2category(category);
		return empleos;
	}

	public List<Empleo> getAllEmpleos(Integer pageNo, Integer pageSize, String sortBy) {
		Iterable<Empleo> response = repository.findAll();

		return (List<Empleo>) response;
	}
}
