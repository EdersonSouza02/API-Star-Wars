package com.api.starwars;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StarWarsApiTest {

    @Test
    public void retornarOkSeGetLocalForSucesso()
            throws ClientProtocolException, IOException {

        HttpUriRequest request = new HttpGet("http://localhost:8080/planet/");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void retornarOkSeEncontrarPlanetaPeloID()
            throws IOException {

        String id = "4897c688-577f-46c5-a3ba-80c25ba5eb05";
        HttpUriRequest request = new HttpGet("http://localhost:8080/planet/id/" + id);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void retornarOkSeAcharPlanetaPeloNome()
            throws IOException {

        String nome = "Coruscant";
        HttpUriRequest request = new HttpGet("http://localhost:8080/planet/name/" + nome);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void retornarOkSeDispararGetWebclient()
            throws IOException {


        HttpUriRequest request = new HttpGet("http://localhost:8080/webclient/planets/");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void retornarOkSeDispararGetFilmsWebclient()
            throws IOException {


        HttpUriRequest request = new HttpGet("http://localhost:8080/webclient/films/");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }
}
