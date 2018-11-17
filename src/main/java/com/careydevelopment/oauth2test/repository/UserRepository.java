package com.careydevelopment.oauth2test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.careydevelopment.oauth2test.model.User;

public interface UserRepository extends MongoRepository<User, String> {
  User findByUsername(String username);
}
