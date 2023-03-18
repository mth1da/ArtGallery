package com.miage.app.Entity;

import com.miage.app.dao.jdbc.DAOContext;

import java.util.Date;

public class Reservation {
    private final int idReservation ;
    private Date date;
    private double price;
    private int idUser;

    //Constructeur
    public Reservation(int idReservation,Date date,double p,int idUser) {
        this.idReservation = idReservation;
        this.date=date;
        this.price=p;
        this.idUser=idUser;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public void setDate(Date date){
        this.date=date;
    }

    public int getIdReservation(){
        return this.idReservation;
    }

    public int getIdUser(){
        return this.idUser;
    }

    public Date getDate(){
        return this.date;
    }

    public double getPrice(){
        return this.price;
    }

}
