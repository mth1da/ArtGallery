package com.miage.app.dao.repository;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ReservationDAO;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository implements ReservationDAO {
    private static List<Reservation> reservationList=new ArrayList<>();
    @Override
    public void createReservation(Reservation r) {
        reservationList.add(r);
    }

    @Override
    public void updateReservation(Reservation r) {

    }

    @Override
    public void deleteReservation(Reservation r) {
        reservationList.remove(r);
    }

    @Override
    public Reservation getReservationById(int id) {
        return null;
    }

    @Override
    public Iterable<Reservation> getAllReservations() {
        return reservationList;
    }


}
