package com.miage.app.dao;

import com.miage.app.Entity.Reservation;

public interface ReservationDAO {

    public abstract void createReservation(Reservation r);


    public abstract void deleteReservation(int r);

    public abstract Iterable<Reservation> getReservationByUser(int id);
}
