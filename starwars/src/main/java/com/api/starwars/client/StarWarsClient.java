package com.api.starwars.client;



import com.api.starwars.Configuration.WebClientConfiguration;
import com.api.starwars.model.Planet;
import com.api.starwars.response.ListFilmResponse;
import com.api.starwars.response.ListPlanetResponse;
import com.api.starwars.service.PlanetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;


@Service
@Slf4j
public class StarWarsClient {


    @Autowired
    private WebClientConfiguration webClientConfiguration;

    @Autowired
    private PlanetService planetService;



    public ParallelFlux<ListPlanetResponse> getAllPlanets() {
        log.info("Find Planets");
        ParallelFlux<ListPlanetResponse> planet = webClientConfiguration.createWebClient().get().uri("https://swapi.dev/api/planets")
                .retrieve()
                .bodyToFlux(ListPlanetResponse.class).parallel(2).runOn(Schedulers.parallel());

        planet.subscribe(listPlanetResponse -> validExitsPlanet(listPlanetResponse));
        return planet;

    }


    private void insert(ListPlanetResponse listPlanetResponse, int cont) {
        Planet planet = new Planet();
        UUID id = UUID.randomUUID();
        planet.setId(id);
        planet.setName(listPlanetResponse.getResults().get(cont).getName());
        planet.setClimate(listPlanetResponse.getResults().get(cont).getClimate());
        planet.setTerrain(listPlanetResponse.getResults().get(cont).getTerrain());
        planet.setFilms(listPlanetResponse.getResults().get(cont).getFilms());
        planet.setAparitionFilms(listPlanetResponse.getResults().get(cont).getFilms().size());

        planetService.save(planet).subscribe();
    }

    private void validExitsPlanet(ListPlanetResponse listPlanetResponse) {
        for (int cont = 0; cont<listPlanetResponse.getResults().size();cont++){
            String name = listPlanetResponse.getResults().get(cont).getName();
            int finalCont = cont;
            planetService.findByName(name)
                    .defaultIfEmpty(new Planet())
                    .subscribe(planet ->
                        {
                            if (planet.getName()==null) {
                                insert(listPlanetResponse,finalCont);}});
        }

    }


    public ParallelFlux<ListFilmResponse> getAllFilms() {
        log.info("Find Films");

        ParallelFlux<ListFilmResponse> film = webClientConfiguration.createWebClient().get().uri("https://swapi.dev/api/films")
                .retrieve()
                .bodyToFlux(ListFilmResponse.class).parallel(2).runOn(Schedulers.parallel());

        return film;
    }




}






