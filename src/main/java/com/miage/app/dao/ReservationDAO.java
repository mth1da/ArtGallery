package com.miage.app.dao;

import com.miage.app.Entity.Reservation;

public interface ReservationDAO {

    void createReservation(Reservation reservation);

    void deleteReservation(int r);

    Iterable<Reservation> getReservationByUser(int id);
}
