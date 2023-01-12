package com.reactivecrud.repository;

import com.reactivecrud.entity.Greeting;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends ReactiveMongoRepository<Greeting, String> {
}
