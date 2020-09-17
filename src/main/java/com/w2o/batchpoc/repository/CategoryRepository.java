package com.w2o.batchpoc.repository;

import com.w2o.batchpoc.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	public Category findCategoryBycategoryId(@Param ("categoryIdIn") String categoryId);
}
