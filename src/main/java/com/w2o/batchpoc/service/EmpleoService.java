package com.amdocs.jceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.jceapi.domain.Empleo;
import com.amdocs.jceapi.repository.EmpleoRepository;

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
