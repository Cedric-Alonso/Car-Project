package com.reservation.reservation.Dao;

import com.reservation.reservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationApi extends CrudRepository<Reservation, Integer> {
    Reservation findById(int id);

    Reservation[] getAllByIduser(int user);

    Reservation[] getAllByIdvoiture(int car);

}
