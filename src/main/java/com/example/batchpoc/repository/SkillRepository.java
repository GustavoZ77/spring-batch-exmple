package com.example.batchpoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.batchpoc.domain.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

	public List<Skill> findSkillsBySkill2empleo(Long empleo);
}
