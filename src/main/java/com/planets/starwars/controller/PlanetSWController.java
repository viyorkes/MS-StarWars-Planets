package com.planets.starwars.controller;


import com.planets.starwars.DTO.SWAPIPlanetDTO;
import com.planets.starwars.DTO.SWAPIResultDTO;
import com.planets.starwars.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class PlanetSWController {



    @Autowired
    PlanetService planetService;

    @Autowired
    public PlanetSWController(PlanetService planetService) {
        this.planetService = planetService;
    }


    @GetMapping("/retrieve/planets")
    public Mono<SWAPIResultDTO> getAllPlanetsFromSWAPI() {
        return this.planetService.getAllPlanetsFromSWAPI();
    }

    @GetMapping("/retrieve/namesPlanets")
    public Mono<List<String>> getAllPlanetsNamesFromSWAPI() {
        return this.planetService.getAllPlanetsNamesFromSWAPI();
    }

    @GetMapping("/retrieve/planets/terrain" + "/{name}")
    public Mono<List<SWAPIPlanetDTO>> getAllPlanetsTerrainFromSWAPI(@PathVariable String name) {
        return this.planetService.getAllPlanetsFiltersTerrainFromSWAPI(name);
    }

    @GetMapping("/retrieve/planets/climates" + "/{name_climates}")
    public Mono<List<SWAPIPlanetDTO>> getAllPlanetsClimatesFromSWAPI(@PathVariable String name) {
        return this.planetService.getAllPlanetsFiltersClimatesFromSWAPI(name);
    }


}
