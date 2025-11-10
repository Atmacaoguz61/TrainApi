package com.example.TrainApi.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {

    private boolean RezervasyonYapilabilir;
    private List<YerlesimAyrinti> YerlesimAyrinti;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class YerlesimAyrinti {

        private String VagonAdi;
        private int KisiSayisi;
    }
}
