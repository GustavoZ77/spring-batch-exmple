package com.amdocs.jceapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amdocs.jceapi.domain.Empleo;

@Repository
public interface EmpleoRepository extends CrudRepository<Empleo, Long> {

	public List<Empleo> findEmpleosByEmpleo2category(@Param("categoriaId") Long categoriaId);
}
