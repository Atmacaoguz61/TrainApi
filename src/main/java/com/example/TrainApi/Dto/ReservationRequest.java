package com.example.TrainApi.Dto;

import com.example.TrainApi.Entity.Train;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    @JsonProperty("Tren")
    private Train Tren;

    @JsonProperty("RezervasyonYapilacakKisiSayisi")
    private int RezervasyonYapilacakKisiSayisi;

    @JsonProperty("KisilerFarkliVagonlaraYerlestirilebilir")
    private boolean KisilerFarkliVagonlaraYerlestirilebilir;
}
