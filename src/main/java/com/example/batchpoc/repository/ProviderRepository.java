package com.example.batchpoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.batchpoc.domain.Provider;
import com.example.batchpoc.domain.Skill;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {

	public List<Provider> findProvidersBySkills(Skill skillId);
}
