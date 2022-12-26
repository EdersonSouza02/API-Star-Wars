package com.api.starwars.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ListFilmResponse {


    private List<FilmResponse> results;


    public List<FilmResponse> getResults() {
        return results;
    }

    public void setResults(List<FilmResponse> results) {
        this.results = results;
    }

    public ListFilmResponse() {

    }
}
