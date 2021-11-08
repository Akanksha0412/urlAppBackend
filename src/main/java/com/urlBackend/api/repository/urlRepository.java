package com.urlBackend.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.urlBackend.api.model.urlData;

@Repository
public interface urlRepository extends MongoRepository<urlData,String>{

}
