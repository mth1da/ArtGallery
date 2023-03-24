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
    public void deleteReservation(int r) {

    }

    @Override
    public Reservation getReservationById(int id) {

        //Retourne la réservation à partir de l'id
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

    @Override
    public Iterable<Reservation> getReservationByUser(int id) {
        return null;
    }


}
