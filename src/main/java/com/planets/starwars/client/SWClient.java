package com.planets.starwars.client;

import com.planets.starwars.DTO.SWAPIResultDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SWClient {

    private WebClient webClient = WebClient.create("https://swapi.dev/api/");

    public Mono<SWAPIResultDTO> getAllPlanets() {

        return webClient
                .get()
                .uri("planets/")
                .retrieve()
                .bodyToMono(SWAPIResultDTO.class);

    }

}
