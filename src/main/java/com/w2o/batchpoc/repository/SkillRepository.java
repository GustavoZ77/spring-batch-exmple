package com.amdocs.jceapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amdocs.jceapi.domain.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

	public List<Skill> findSkillsBySkill2empleo(Long empleo);
}
