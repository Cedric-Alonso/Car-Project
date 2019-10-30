//package com.consume.API.consume.controller;
//
//import com.consume.API.consume.model.Car;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.client.RestTemplate;
//
//public class API_Controller {
//
//    RestTemplate restTemplate = new RestTemplate();
//
//    @Bean
//    public Car[] carsAPI (){
//        String url = "http://localhost:8081/produits";
//        Car[] response = restTemplate.getForObject(url, Car[].class);
//        return response;
//    }
//
//    @Bean
//    public Car carAPI (@PathVariable int id){
//        String url = "http://localhost:8081/produits/"+id;
//        Car response = restTemplate.getForObject(url, Car.class);
//        return response;
//    }
//
//    @Bean
//    public Car addAPI (){
//        String url = "http://localhost:8081/produits/{id}";
//        Car response = restTemplate.postForObject(url, Car.class);
//        return response;
//    }
//
////
////    @Bean
////    public Car updateAPI (){
////        Car updatedInstance = new Car("newName");
////        updatedInstance.setId(createResponse.getBody().getId());
////        String resourceUrl =
////                fooResourceUrl + '/' + createResponse.getBody().getId();
////        HttpEntity<Foo> requestUpdate = new HttpEntity<>(updatedInstance, headers);
////        template.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
////        //////////////////////////////////////////////////////
//////        String url = "http://localhost:8081/produits/{id}";
//////        Car response = restTemplate.put(url, Car.class);
//////        return response;
////    }
////    @Bean
////    public Car deleteAPI (@PathVariable int id){
////        String url = "http://localhost:8081/produits/"+id;
////        restTemplate.delete(url);
////    }
//
//}
