package com.miage.app.utilisateurs;

import java.util.List;

import com.miage.app.oeuvres.Oeuvre;
import com.miage.app.repository.ArtisteRepository;

public class Artiste implements ArtisteRepository {
    
    public String nom;
    public String prenom;
    public String dateNaissance;

    public Artiste(String nom, String prenom, String pseudo, String dateNaissance, List<Oeuvre> realisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getArtiste() {
        return this.nom + " " + this.prenom;
    }

}