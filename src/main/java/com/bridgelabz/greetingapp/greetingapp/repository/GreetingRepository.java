package com.bridgelabz.greetingapp.greetingapp.repository;

import com.bridgelabz.greetingapp.greetingapp.model.GreetingMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GreetingRepository extends MongoRepository<GreetingMessage, Long> {
}
