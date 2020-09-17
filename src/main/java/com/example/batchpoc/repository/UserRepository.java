package com.example.batchpoc.repository;

import com.example.batchpoc.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
