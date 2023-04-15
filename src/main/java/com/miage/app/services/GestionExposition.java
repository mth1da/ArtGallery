package com.miage.app.services;

import com.miage.app.Entity.Exhibition;
import com.miage.app.Entity.Reservation;
import com.miage.app.dao.ExhibitionDAO;
import com.miage.app.dao.ReservationDAO;

public class GestionExposition {
    private ExhibitionDAO exhibitionDAO;
    private ReservationDAO reservationDAO;

    public GestionExposition(ExhibitionDAO e, ReservationDAO r){
        this.exhibitionDAO=e;
        this.reservationDAO=r;
    }

}
