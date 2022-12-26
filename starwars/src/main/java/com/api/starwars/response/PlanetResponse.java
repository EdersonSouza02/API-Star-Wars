package com.api.starwars.response;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class PlanetResponse{

    private String name;
    private String climate;
    private String terrain;
    private List<FilmResponse> films;




    public List<FilmResponse> getFilms() {
        return films;
    }

    public void setFilms(List<FilmResponse> films) {
        this.films = films;
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


    public PlanetResponse() {

    }



}
