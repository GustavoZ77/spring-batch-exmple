package com.amdocs.jceapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.jceapi.domain.Skill;
import com.amdocs.jceapi.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository repository;
	
	public List<Skill> findSkillsByEmpleo(Long empleo) {
		return repository.findSkillsBySkill2empleo(empleo);
	}
	
	public Optional<Skill> findById(Long skillId) {
		return repository.findById(1L);
	}

}
