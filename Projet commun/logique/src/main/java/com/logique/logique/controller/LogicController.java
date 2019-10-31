package com.logique.logique.controller;

import com.logique.logique.model.Profil;
import com.logique.logique.model.Reservation;
import com.logique.logique.service.ReservationApi;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api()
@RestController
public class LogicController {

    @Autowired
    ReservationApi reservationApi;

    ReservationController reservationController = new ReservationController();

    @GetMapping("/profil")
    public String getProfil(int idReserv, int idUser, int idCar) {
//        Profil profil = new Profil(reservationController.readCarReserv(idReserv),idUser, idCar)
        return "ok";
    }

}
