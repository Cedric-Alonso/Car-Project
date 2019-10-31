package com.logique.logique.service;

import com.logique.logique.model.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationApi {

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8082/reservations/";


    public Reservation[] findAll() {
        return restTemplate.getForObject(url , Reservation[].class);
    }
    public Reservation findById(int id) {
        return restTemplate.getForObject(url + id, Reservation.class);
    }
    public Reservation[] findByIduser(int id) {
        return restTemplate.getForObject(url + "user/" + id, Reservation[].class);
    }
    public Reservation[] findByIdvoiture(int id) {
        return restTemplate.getForObject(url + "car/" + id, Reservation[].class);
    }
    public void add(Reservation reservation){
        restTemplate.postForObject(url, reservation, String.class);
    }
    public void modify(Reservation reservation){
        restTemplate.put(url, reservation, String.class);
    }
    public void delete(int id){
        restTemplate.delete(url + id, String.class);
    }
}
