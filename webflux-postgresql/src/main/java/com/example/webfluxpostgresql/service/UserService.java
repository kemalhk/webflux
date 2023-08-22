package com.example.webfluxpostgresql.service;

import com.example.webfluxpostgresql.dto.UserDto;
import com.example.webfluxpostgresql.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User>create(Mono<UserDto>userDtoMono);
    Mono<User>update(Integer userId,Mono<UserDto>userDtoMono);
    Mono<Void>delete(Integer userId);
    Flux<User> list();
}
