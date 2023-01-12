package com.reactivecrud.service;

import com.reactivecrud.dto.GreetingDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GreetingService {
    Flux<GreetingDTO> getAll();

    Mono<GreetingDTO> getById(String id);

    Mono<Void> update(GreetingDTO greetingDTO);

    Mono<Void> create(GreetingDTO greetingDTO);

    Mono<Void> deleteById(String id);
}
