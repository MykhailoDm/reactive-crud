package com.reactivecrud.service.impl;

import com.reactivecrud.dto.GreetingDTO;
import com.reactivecrud.repository.GreetingRepository;
import com.reactivecrud.service.GreetingService;
import com.reactivecrud.util.GreetingMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.reactivecrud.util.GreetingMapper.greetingDTOtoGreeting;

@Service
@AllArgsConstructor
@Transactional
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository greetingRepository;

    @Override
    public Flux<GreetingDTO> getAll() {
        return greetingRepository.findAll()
                .map(GreetingMapper::greetingToGreetingDTO);
    }

    @Override
    public Mono<GreetingDTO> getById(String id) {
        return greetingRepository.findById(id)
                .map(GreetingMapper::greetingToGreetingDTO);
    }

    @Override
    public Mono<Void> update(GreetingDTO greetingDTO) {
        return greetingRepository.save(GreetingMapper.greetingDTOtoGreeting(greetingDTO))
                .flatMap(g -> Mono.empty());
    }

    @Override
    public Mono<Void> create(GreetingDTO greetingDTO) {
        return greetingRepository.save(greetingDTOtoGreeting(greetingDTO))
                .flatMap(g -> Mono.empty());
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return greetingRepository.deleteById(id);
    }
}
