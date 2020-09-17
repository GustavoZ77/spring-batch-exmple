package com.amdocs.jceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.jceapi.domain.Provider;
import com.amdocs.jceapi.domain.Skill;
import com.amdocs.jceapi.repository.ProviderRepository;

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
