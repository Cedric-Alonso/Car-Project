package com.consume.API.consume.model;

public class Car {

    private String brand;
    private String carmodel;

    public Car() {

    }

    public Car(String brand, String carmodel) {
        this.brand = brand;
        this.carmodel = carmodel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

}