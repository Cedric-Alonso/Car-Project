package com.logique.logique.model;

public class Profil {
    private Reservation[] reservation;
    private User[] user;
    private Car[] car;

    public Profil(Reservation[] reservation, User[] user, Car[] car) {
        this.reservation = reservation;
        this.user = user;
        this.car = car;
    }

    public Reservation[] getReservation() {
        return reservation;
    }

    public void setReservation(Reservation[] reservation) {
        this.reservation = reservation;
    }

    public User[] getUser() {
        return user;
    }

    public void setUser(User[] user) {
        this.user = user;
    }

    public Car[] getCar() {
        return car;
    }

    public void setCar(Car[] car) {
        this.car = car;
    }
}
