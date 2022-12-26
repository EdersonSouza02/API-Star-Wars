package com.api.starwars.controller;


import com.api.starwars.service.PlanetService;
import com.api.starwars.model.Planet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/planet")
@Slf4j
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Mono<Planet> create(@RequestBody final Mono<Planet> planet) {

        return planet.flatMap(planetService::save)
                .onErrorMap(error -> new Exception("Erro ao salvar"))
                .doOnNext(p -> log.info("Create new Planet - {}", p));

    }


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<Planet> findAll() {


        return planetService.findAll()
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .doOnComplete(() -> log.info("Get all planets"));


    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Planet> findbyId(@PathVariable final UUID id) {

        return planetService.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .doOnNext(p -> log.info("Get planet by id {}", id));

    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Planet>  findbyName(@PathVariable final String name) {

        return planetService.findByName(name)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> delete(@PathVariable final UUID id) {

        return planetService.deleteByCode(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .doOnNext(p -> log.info("Delete planet sucess"));


    }


}








