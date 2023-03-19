package com.miage.app.dao.repository;


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
        Reservation reservation=null;
        for(Reservation currReservation : reservationList){
            if(currReservation.getIdReservation()==id){
                reservation=currReservation;
            }
        }
        return reservation;
    }

    @Override
    public Iterable<Reservation> getAllReservations() {
        return reservationList;
    }


}
