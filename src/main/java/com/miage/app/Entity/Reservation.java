package com.miage.app.Entity;

import com.miage.app.dao.jdbc.DAOContext;

import java.util.Date;

public class Reservation {
    private int idReservation ;
    private Date date;
    private double price;
    private int idUser;

    private int idExhibition;

    //Constructeur
    public Reservation(int idUser,int idExhibition) {
        this.idUser=idUser;
        this.idExhibition=idExhibition;
    }

    public Reservation(int idReservation, java.sql.Date date, double price, int idUser) {
        this.date=date;
        this.date=date;
        this.price=price;
        this.idUser=idUser;
    }

    public void setIdReservation(int id){
        this.idReservation = id;
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

    public int getIdExhibition(){
        return this.idExhibition;
    }

    public void setIdExhibition(int id){
        this.idExhibition=id;
    }

    public String getInfoReservation(){
        return "Vous avez réserver l'éxibition "+getIdExhibition();
    }

}
