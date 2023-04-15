package com.miage.app.services;

import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ExhibitionDAO;
import com.miage.app.dao.ReservationDAO;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ReservationBDD;

import java.util.Date;

public class GestionReservation {

    private ReservationDAO reservationDAO;



    public GestionReservation(ReservationDAO r){
        this.reservationDAO=r;
    }

    public void buyExhibition(int exhibitionId,int user,Date date){
        Reservation r=new Reservation(user,exhibitionId,date);
        reservationDAO.createReservation(r);
    }


    public void deleteReservation(int idR){
        reservationDAO.deleteReservation(idR);
    }

}
