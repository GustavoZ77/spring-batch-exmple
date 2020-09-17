package com.w2o.batchpoc.service;

import java.util.List;
import java.util.Optional;

import com.w2o.batchpoc.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w2o.batchpoc.domain.Skill;

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
