package com.consume.API.consume.services;

import com.consume.API.consume.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarService {

    RestTemplate restTemplate = new RestTemplate();

    public Car[] findAll(){
        return restTemplate.getForObject("http://localhost:8081/produits", Car[].class);
    }

    public Car getById(int id) {
        return restTemplate.getForObject("http://localhost:8081/produits/" + id, Car.class);
    }

    public void save(Car car){
        restTemplate.postForObject("http://localhost:8081/produits", car, Car.class);
    }

    public void modify(Car car){
        restTemplate.put("http://localhost:8081/produits/", car, Car.class);
    }

    public void delete(int id){
        restTemplate.delete("http://localhost:8081/produits/"+id,Car.class);
    }
}
