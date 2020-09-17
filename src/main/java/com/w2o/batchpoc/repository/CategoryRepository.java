package com.amdocs.jceapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amdocs.jceapi.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	public Category findCategoryBycategoryId(@Param ("categoryIdIn") String categoryId);
}
