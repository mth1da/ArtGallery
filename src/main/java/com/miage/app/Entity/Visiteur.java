package com.miage.app.Entity;

import java.util.ArrayList;
import java.util.List;

public class Visiteur extends User{

    private List<Oeuvre> myBoughtOeuvres=new ArrayList<>();

    public Visiteur(String nom, String prenom, String mdp, String email) {
        super(nom, prenom, mdp, email);
    }



    @Override
    public void displayUser() {
        System.out.println("Coordonnées du Visiteur : ");
        System.out.println("Nom : "+getNom());
        System.out.println("Prénom : "+getPreNom());
        System.out.println("Email : "+getEmail());
    }

    @Override
    public String getType() {
        return "visiteur";
    }

    public void buyOeuvre(Oeuvre o){
        myBoughtOeuvres.add(o);
    }

    public List<Oeuvre> getBoughtOeuvres(){
        return myBoughtOeuvres;
    }

}
