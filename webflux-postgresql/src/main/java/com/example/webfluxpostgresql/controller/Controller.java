package com.example.webfluxpostgresql.controller;

import com.example.webfluxpostgresql.dto.UserDto;
import com.example.webfluxpostgresql.entity.User;
import com.example.webfluxpostgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;

    @GetMapping
    Flux<User> list() {
        return userService.list().log();
    }

    @PostMapping
    Mono<User> create(@RequestBody Mono<UserDto> userDto) {
        return userService.create(userDto).log();
    }

    @DeleteMapping("/{userId}")
    Mono<Void> delete(@PathVariable Integer userId) {
        return userService.delete(userId).log();
    }

    @PutMapping("/{userId}")
    Mono<ResponseEntity<User>> update(@PathVariable Integer userId, @RequestBody Mono<UserDto> userDto) {
        return userService.update(userId, userDto).map(ResponseEntity::ok).defaultIfEmpty(
                ResponseEntity.notFound().build()).log();
    }


}
