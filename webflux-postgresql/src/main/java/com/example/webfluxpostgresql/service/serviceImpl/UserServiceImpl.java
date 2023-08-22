package com.example.webfluxpostgresql.service.serviceImpl;

import com.example.webfluxpostgresql.dto.UserDto;
import com.example.webfluxpostgresql.entity.User;
import com.example.webfluxpostgresql.repository.UserRepository;
import com.example.webfluxpostgresql.service.UserService;
import com.example.webfluxpostgresql.utils.UserUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public Mono<User>create(Mono<UserDto>userDtoMono){
        return userDtoMono.map(UserUtils::toUser).flatMap(userRepository::save).log();
    }

    @Override
    public Mono<User> update(Integer userId, Mono<UserDto> userDto) {
        return userRepository.findById(userId)
                .flatMap(user -> userDto
                        .map(UserUtils::toUser)
                        .doOnNext(u -> u.setId(userId)))
                .flatMap(userRepository::save).log();
    }

    @Override
    public Mono<Void> delete(Integer userId) {
        return userRepository.deleteById(userId).log();
    }

    @Override
    public Flux<User> list() {
        return userRepository.findAll().log();
    }
}
