package com.miage.app.oeuvres;

import java.util.List;

import com.miage.app.exposition.Pays;
import com.miage.app.repertoire.Critique;
import com.miage.app.utilisateurs.Artiste;
import com.miage.app.utilisateurs.Proprio;

public class Oeuvre {

    public String nomOeuvre;
    public String dateOeuvre;
    public String mouvement;
    public Artiste artiste;
    public int prix;
    public Critique critique;

    public Oeuvre(String nomOeuvre, String dateOeuvre, String mouvement, Artiste artiste, int prix, Critique critique) {
        this.nomOeuvre = nomOeuvre;
        this.dateOeuvre = dateOeuvre;
        this.mouvement = mouvement;
        this.artiste = artiste;
        this.prix = prix;
        this.critique = critique;
    }

    public String getNomOeuvre() {
        return this.nomOeuvre;
    }

    public String getDateOeuvre() {
        return this.dateOeuvre;
    }

    public String getMouvement() {
        return this.mouvement;
    }

    public int getPrix() {
        return this.prix;
    }

    //Ajouter une oeuvre

    public List<Oeuvre> ajoutOeuvre(Oeuvre oeuvre) {

        Proprio.oeuvres.add(oeuvre);
        return Proprio.oeuvres;
            
    }

    //Supprimer une oeuvre

    public List<Oeuvre> supprimeOeuvre(Oeuvre oeuvre) {

        Proprio.oeuvres.remove(oeuvre);
        return Proprio.oeuvres;
            
    }

    //Afficher les informations d’une oeuvre

    public void afficheInfosOeuvre(Oeuvre oeuvre, Pays pays, Artiste artiste) {
        System.out.println("Nom de l'oeuvre: " + oeuvre.getNomOeuvre());
        System.out.println("Date de l'oeuvre: " + oeuvre.getDateOeuvre());
        System.out.println("Mouvement: " + oeuvre.getMouvement());
        System.out.println("Thème de l'oeuvre: " + pays.getPays());
        System.out.println("Artiste: " + artiste.getArtiste());
        System.out.println("Prix: " + oeuvre.getPrix());
    }

}

