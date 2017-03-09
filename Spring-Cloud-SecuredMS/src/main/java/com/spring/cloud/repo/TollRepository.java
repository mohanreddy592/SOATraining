package com.spring.cloud.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.model.TollUsage;

@Repository
public interface TollRepository extends MongoRepository<TollUsage, String> {

}
