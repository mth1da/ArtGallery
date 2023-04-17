package com.miage.app.Entity;

import java.util.Date;

public class Reservation {
    private int idReservation ;
    private Date date;
    private double price;
    private int idUser;
    private int idExhibition;

    //Constructeur
    public Reservation(int idUser,int idExhibition, Date date) {
        this.idUser=idUser;
        this.idExhibition=idExhibition;
        this.date=date;
    }

    public Reservation(int idUser,int idExhibition) {
        this.idUser=idUser;
        this.idExhibition=idExhibition;
    }

    public int getIdReservation(){
        return this.idReservation;
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
        return "Vous avez réservé l'exposition "+getIdExhibition();
    }

}
