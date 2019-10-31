package com.logique.logique.controller;

import com.logique.logique.model.Reservation;
import com.logique.logique.service.ReservationApi;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api()
@RestController
public class ReservationController {

    @Autowired
    ReservationApi reservationApi;

    @GetMapping("/reservations")
    public Reservation[] listReserv() {
        return reservationApi.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation readReserv(@PathVariable int id) {
        return reservationApi.findById(id);
    }

    @GetMapping("/reservations/user/{id}")
    public Reservation[] readUserReserv(@PathVariable int id){
        return reservationApi.findByIduser(id);
    }

    @GetMapping("/reservations/car/{id}")
    public Reservation[] readCarReserv(@PathVariable int id){
        return reservationApi.findByIdvoiture(id);
    }

    @PostMapping("/reservations")
    public String addReserv(@RequestBody Reservation reserv) {
        if (readReserv(reserv.getId()) == null) {
            reservationApi.add(reserv);
            return "add ok";
        } else {
            return "L'élément existe déjà.";
        }
    }

    @PutMapping("/reservations")
    public String modifReserv(@RequestBody Reservation reserv) {
        if (readReserv(reserv.getId()) != null) {
            reservationApi.modify(reserv);
            return "modify ok";
        } else {
            return "L'élément n'a pas était trouver.";
        }
    }

    @DeleteMapping("/reservations/{id}")
    public String deleteReserv(@PathVariable int id) {
        if (readReserv(id) != null) {
            reservationApi.delete(id);
            return "delete ok";
        }
        else {
            return "imposible l'element n'existe pas";
        }
    }

    @DeleteMapping("/reservations")
    public String deleteAll() {
        Reservation[] allData = listReserv();
        for (int i = 0; i< allData.length; i++){
            int data = allData[i].getId();
            reservationApi.delete(data);
        }
            return "delete all ok";
    }

}
