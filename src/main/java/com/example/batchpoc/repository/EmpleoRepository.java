package com.example.batchpoc.repository;

import java.util.List;

import com.example.batchpoc.domain.Empleo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleoRepository extends CrudRepository<Empleo, Long> {

	public List<Empleo> findEmpleosByEmpleo2category(@Param("categoriaId") Long categoriaId);
}
