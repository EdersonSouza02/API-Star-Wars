package com.api.starwars.model;


import com.api.starwars.response.FilmResponse;
import com.api.starwars.response.ListFilmResponse;
import com.api.starwars.response.ListPlanetResponse;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class Planet {

    @Id
    private UUID id;
    private String name;
     private String climate;
     private String terrain;
     private List<FilmResponse> films;
     private int aparitionFilms;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public List<FilmResponse> getFilms() {
        return films;
    }

    public void setFilms(List<FilmResponse> films) {
        this.films = films;
    }

    public int getAparitionFilms() {
        return aparitionFilms;
    }

    public void setAparitionFilms(int aparitionFilms) {
        this.aparitionFilms = aparitionFilms;
    }

    public Planet() {

    }
}
