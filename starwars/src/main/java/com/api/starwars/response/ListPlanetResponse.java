package com.api.starwars.response;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ListPlanetResponse {

    private List<PlanetResponse> results;




    @Override
    public String toString() {
        return "ListPlanetResponse{" +
                "results=" + results +
                '}';
    }

    public List<PlanetResponse> getResults() {
        return results;
    }

    public void setResults(List<PlanetResponse> results) {
        this.results = results;
    }
}
