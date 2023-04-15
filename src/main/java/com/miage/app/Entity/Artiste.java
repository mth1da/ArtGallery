package com.miage.app.Entity;

import java.util.List;

public class Artiste {

    private final int id;

    private final String name;
    private final String lastName;
    private final String fonction;

    private List<Oeuvre> oeuvres;

    //Constructeur
    public Artiste(int id, String name, String lastName, String fonction){
        this.id = id;
        this.name=name;
        this.lastName=lastName;
        this.fonction=fonction;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public List<Oeuvre> getOeuvres(){
        return this.oeuvres;
    }

    public int getId(){
        return this.id;
    }

    public String getFonction(){
        return this.fonction;
    }

    public void addOeuvre(Oeuvre o){
        this.oeuvres.add(o);
    }

}
