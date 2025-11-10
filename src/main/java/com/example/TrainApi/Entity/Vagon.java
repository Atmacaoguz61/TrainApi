package com.example.TrainApi.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vagon {

    @JsonProperty("Ad")
    private String Ad;

    @JsonProperty("Kapasite")
    private int Kapasite;

    @JsonProperty("DoluKoltukAdet")
    private int DoluKoltukAdet;
}
