package com.miage.app.utilisateurs;

import java.util.ArrayList;
import java.util.List;

import com.miage.app.oeuvres.Oeuvre;
import com.miage.app.repository.OeuvreRepository;

public class Proprio extends User implements OeuvreRepository {

    public static List<Oeuvre> oeuvres = new ArrayList<Oeuvre>(); 
    
    public Proprio(String nom, String prenom, String pseudo, String photoPath, String motDePasse, List<Oeuvre> oeuvres) {
        super(nom, prenom, pseudo, photoPath, motDePasse);
        Proprio.oeuvres = oeuvres;
    }

    //Afficher la liste des oeuvres exposées 

    public void afficheOeuvre() {
        for(Oeuvre oeuvre: oeuvres) {
            System.out.println(oeuvre);
        }
    }
    
}