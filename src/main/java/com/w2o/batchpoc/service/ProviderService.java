package com.w2o.batchpoc.service;

import java.util.List;

import com.w2o.batchpoc.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w2o.batchpoc.domain.Provider;
import com.w2o.batchpoc.domain.Skill;

@Service
public class ProviderService {

	@Autowired
	private ProviderRepository repository;
	
	
	public List<Provider> findProviderBySkill(Long skillId) {
		Skill objSkill = new Skill();
		objSkill.setSkillId(skillId);
		return repository.findProvidersBySkills(objSkill);
	}
}
