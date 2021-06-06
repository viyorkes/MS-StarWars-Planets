package com.planets.starwars.DTO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class SWAPIResultDTO {

    private Integer count;
    private String next;
    private String previous;
    private List<SWAPIPlanetDTO> results;

}

