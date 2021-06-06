package com.planets.starwars.service;

import com.planets.starwars.DTO.SWAPIPlanetDTO;
import com.planets.starwars.DTO.SWAPIResultDTO;
import com.planets.starwars.client.SWClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanetService {

    private final SWClient swClient;

    @Autowired
    public PlanetService(SWClient swClient) {
        this.swClient = swClient;
    }


    public Mono<SWAPIResultDTO> getAllPlanetsFromSWAPI() {
        return this.swClient.getAllPlanets();
    }

    public Mono<List<String>> getAllPlanetsNamesFromSWAPI() {
        return this.swClient.getAllPlanets()
                .map(SWAPIResultDTO::getResults)
                .map(p->p.stream().map(SWAPIPlanetDTO::getName).collect(Collectors.toList()));
    }


    public Mono<List<SWAPIPlanetDTO>> getAllPlanetsFiltersTerrainFromSWAPI(String name) {
        return this.swClient.getAllPlanets()
                .map(SWAPIResultDTO::getResults)
                .map(p->p.stream().filter(i -> i.getTerrain().equals(name)).collect(Collectors.toList()));
    }


    public Mono<List<SWAPIPlanetDTO>> getAllPlanetsFiltersClimatesFromSWAPI(String name){
        return this.swClient.getAllPlanets()
                .map(SWAPIResultDTO::getResults)
                .map(p->p.stream().filter(i -> i.getClimate().equals(name)).collect(Collectors.toList()));
    }

}
