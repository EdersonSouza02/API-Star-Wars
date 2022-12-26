package com.api.starwars.service;


import com.api.starwars.model.Planet;
import com.api.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Service

public class PlanetServiceImpl implements PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    @Override
    public Mono<Planet> save(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public Mono<Planet> findById(UUID id) {
        return planetRepository.findById(id);
    }

    @Override
    public Mono<Planet>  findByName(String name) {
        return planetRepository.findByName(name);
    }

    @Override
    public Mono<Void> deleteByCode(UUID id) {
        return planetRepository.deleteById(id);
    }

    @Override
    public Flux<Planet> findAll() {
        return planetRepository.findAll();
    }



}
