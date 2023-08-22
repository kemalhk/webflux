package com.example.webfluxpostgresql.repository;

import com.example.webfluxpostgresql.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
}
