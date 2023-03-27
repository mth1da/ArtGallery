package com.miage.app.dao;

import com.miage.app.Entity.Reservation;

public interface ReservationDAO {

    public abstract void createReservation(Reservation r);

    public abstract void updateReservation(Reservation r);

    public abstract void deleteReservation(int r);

    public abstract Reservation getReservationById(int id);

    public abstract Iterable<Reservation> getAllReservations();

    public abstract Iterable<Reservation> getReservationByUser(int id);
}
