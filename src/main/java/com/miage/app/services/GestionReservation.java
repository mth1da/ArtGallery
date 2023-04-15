package com.miage.app.services;

import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ExhibitionDAO;
import com.miage.app.dao.ReservationDAO;
import com.miage.app.dao.UserDAO;

import java.util.Date;

public class GestionReservation {
    private int exhibitionId;
    private ReservationDAO reservationDAO;

    private int user;

    public GestionReservation(int e, ReservationDAO r, int user){
        this.exhibitionId=e;
        this.reservationDAO=r;
        this.user=user;
    }

    public void buyExhibition(Date date){
        Reservation r=new Reservation(user,exhibitionId,date);
        reservationDAO.createReservation(r);
    }


    public void deleteReservation(){

    }

}
