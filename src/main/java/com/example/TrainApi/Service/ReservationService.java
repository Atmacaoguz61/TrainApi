package com.example.TrainApi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TrainApi.Dto.ReservationRequest;
import com.example.TrainApi.Dto.ReservationResponse;
import com.example.TrainApi.Entity.Vagon;

@Service
public class ReservationService {

    public ReservationResponse makeReservation(ReservationRequest request) {
        List<ReservationResponse.YerlesimAyrinti> yerlesimler = new ArrayList<>();
        int kisiSayisi = request.getRezervasyonYapilacakKisiSayisi();

        if (request.isKisilerFarkliVagonlaraYerlestirilebilir()) {
            for (Vagon vagon : request.getTren().getVagonlar()) {
                int maxKapasite = (int) Math.floor(vagon.getKapasite() * 0.7);
                int bosKoltuk = maxKapasite - vagon.getDoluKoltukAdet();
                if (bosKoltuk <= 0) {
                    continue;
                }

                int yerlestirilen = Math.min(bosKoltuk, kisiSayisi);
                yerlesimler.add(new ReservationResponse.YerlesimAyrinti(vagon.getAd(), yerlestirilen));
                kisiSayisi -= yerlestirilen;
                if (kisiSayisi == 0) {
                    break;
                }
            }
            return new ReservationResponse(kisiSayisi == 0, kisiSayisi == 0 ? yerlesimler : new ArrayList<>());
        } else {
            for (Vagon vagon : request.getTren().getVagonlar()) {
                int maxKapasite = (int) Math.floor(vagon.getKapasite() * 0.7);
                int bosKoltuk = maxKapasite - vagon.getDoluKoltukAdet();
                if (bosKoltuk >= kisiSayisi) {
                    yerlesimler.add(new ReservationResponse.YerlesimAyrinti(vagon.getAd(), kisiSayisi));
                    return new ReservationResponse(true, yerlesimler);
                }
            }
            return new ReservationResponse(false, new ArrayList<>());
        }
    }
}
