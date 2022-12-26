package com.api.starwars.controller;

import com.api.starwars.client.StarWarsClient;
import com.api.starwars.response.ListFilmResponse;
import com.api.starwars.response.ListPlanetResponse;
import com.api.starwars.service.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class StarWarsController {

    StarWarsClient starWarsClient;
    PlanetService planetService;

    @GetMapping("/planets")
    public ParallelFlux<ListPlanetResponse> getAllPlanets() {

        return starWarsClient.getAllPlanets();

    }

    @GetMapping("/films")
    public ParallelFlux<ListFilmResponse> getAllFilms() {

        return starWarsClient.getAllFilms();

    }






}
