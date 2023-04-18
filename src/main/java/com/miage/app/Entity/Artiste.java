package com.miage.app.Entity;

import java.util.List;

public class Artiste {

    private final int id;
    private final String fonction;
    private final String name;
    private final String prenom;

    private List<Oeuvre> oeuvres;

    //Constructeur
    public Artiste(int id, String nom, String prenom,String fonction){
        this.id=id;
        this.fonction=fonction;
        this.name=nom;
        this.prenom=prenom;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.prenom;
    }

    public List<Oeuvre> getOeuvres(){
        return this.oeuvres;
    }

    public int getId(){
        return this.id;
    }

    public String getStatus(){
        return this.fonction;
    }

    public void addOeuvre(Oeuvre oeuvre){
        this.oeuvres.add(oeuvre);
    }


}
