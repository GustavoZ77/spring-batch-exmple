package com.w2o.batchpoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.w2o.batchpoc.domain.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

	public List<Skill> findSkillsBySkill2empleo(Long empleo);
}
