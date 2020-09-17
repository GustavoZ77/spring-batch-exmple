package com.w2o.batchpoc.repository;

import com.w2o.batchpoc.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
