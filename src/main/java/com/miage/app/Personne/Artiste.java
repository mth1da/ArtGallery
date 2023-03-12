package com.miage.app.Personne;

import java.util.List;

import com.miage.app.Oeuvre.Oeuvre;

public abstract class Artiste {
    private final String name;
    private final String prenom;
    private List<Oeuvre> oeuvres;

    public Artiste(String nom,String prenom){
        this.name=nom;
        this.prenom=prenom;
    }

    public String getName(){
        return this.name;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public List<Oeuvre> getOeuvres(){
        return this.oeuvres;
    }
}
