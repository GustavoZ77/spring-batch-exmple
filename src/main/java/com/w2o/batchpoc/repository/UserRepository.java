package com.amdocs.jceapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.amdocs.jceapi.domain.User;

@RepositoryRestResource(path = "Users", collectionResourceRel = "User")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
