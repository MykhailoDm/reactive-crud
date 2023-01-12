package com.reactivecrud.controller;

import com.reactivecrud.dto.GreetingDTO;
import com.reactivecrud.service.GreetingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/greetings")
@AllArgsConstructor
@RestController
@Slf4j
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping
    public Flux<GreetingDTO> getAll() {
        log.info("Get all greetings");
        return greetingService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<GreetingDTO> getById(@PathVariable String id) {
        log.info("Get greeting by id {}", id);
        return greetingService.getById(id);
    }

    @PutMapping
    public Mono<Void> updateById(@RequestBody GreetingDTO greetingDTO) {
        log.info("Update greeting with id {}", greetingDTO.id());
        return greetingService.update(greetingDTO);
    }

    @PostMapping
    public Mono<Void> create(@RequestBody GreetingDTO greetingDTO) {
        log.info("Create greeting");
        return greetingService.create(greetingDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        log.info("Delete by id {}", id);
        return greetingService.deleteById(id);
    }
}
