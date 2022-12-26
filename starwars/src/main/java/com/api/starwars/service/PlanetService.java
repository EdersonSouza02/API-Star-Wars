package com.api.starwars.service;

import com.api.starwars.model.Planet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public interface PlanetService {

    Mono<Planet> save(Planet planet);

    Mono<Planet> findById(UUID id);

    Mono<Planet>  findByName(String name);

    Mono<Void> deleteByCode(UUID id);

    Flux<Planet> findAll();


}
