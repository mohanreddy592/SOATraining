package com.spring.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.spring.model.TollUsage;

//@Repository
//@RestResource(path = "/tolls")
@RepositoryRestResource(path = "/tolls")
public interface TollRepository extends MongoRepository<TollUsage, String> {

}
