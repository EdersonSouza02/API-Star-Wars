package com.api.starwars.repository;


import com.api.starwars.model.Planet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlanetRepository extends ReactiveMongoRepository<Planet,Long> {

    Mono<Planet> findByName(String name);


    Mono<Void> deleteById(UUID id);

    Mono<Planet> findById(UUID id);
}
