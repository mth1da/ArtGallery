package com.miage.app.Entity;

import java.util.List;

public class Artiste {

    private final int id;

    private final String status;
    private final String name;
    private final String prenom;

    private final int age;
    private List<Oeuvre> oeuvres;

    //Constructeur
    public Artiste(int id, String status, String nom, String prenom, int age){
        this.id=id;
        this.status=status;
        this.name=nom;
        this.prenom=prenom;
        this.age = age;
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
        return this.status;
    }

    public void addOeuvre(Oeuvre o){
        this.oeuvres.add(o);
    }

    public int getAge(){
        return this.age;
    }

}
