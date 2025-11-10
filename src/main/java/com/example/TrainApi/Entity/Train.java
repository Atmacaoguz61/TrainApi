package com.example.TrainApi.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Train {

    @JsonProperty("Ad")
    private String Ad;

    @JsonProperty("Vagonlar")
    private List<Vagon> Vagonlar;
}
