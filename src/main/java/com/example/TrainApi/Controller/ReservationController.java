package com.example.TrainApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainApi.Dto.ReservationRequest;
import com.example.TrainApi.Dto.ReservationResponse;
import com.example.TrainApi.Service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ReservationResponse makeReservation(@RequestBody ReservationRequest request) {
        return reservationService.makeReservation(request);
    }
}
