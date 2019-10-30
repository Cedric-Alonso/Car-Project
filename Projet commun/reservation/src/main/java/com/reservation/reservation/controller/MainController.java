package com.reservation.reservation.controller;

import com.reservation.reservation.Dao.ReservationApi;
import com.reservation.reservation.model.Reservation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.reservation.reservation.Dao.ReservationApi;
import com.reservation.reservation.model.Reservation;
import com.reservation.reservation.controller.*;

@Api()
@RestController
public class MainController {

    @Autowired
    ReservationApi reservationApi;

    @GetMapping("/reservations")
    public Iterable<Reservation> listReserv(){
        return reservationApi.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation readReserv(@PathVariable int id){
        return reservationApi.findById(id);
    }

    @PostMapping("/reservations")
    public String addReserv(@RequestBody Reservation reserv){
        if (readReserv(reserv.getId()) == null) {
            reservationApi.save(reserv);
            return "add ok";
        }else {
            return "L'élément existe déjà.";
        }
    }
    @PutMapping("/reservations")
    public String modifReserv(@RequestBody Reservation reserv){
        if (readReserv(reserv.getId()) != null) {
            reservationApi.save(reserv);
            return "modify ok";
        }else {
            return "L'élément n'a pas était trouver.";
        }
    }
    @DeleteMapping("/reservations/{id}")
    public String deleteReserv(@PathVariable int id){
        Reservation dataDelete = readReserv(id);
        reservationApi.delete(dataDelete);
        return "delete ok";
    }

}
