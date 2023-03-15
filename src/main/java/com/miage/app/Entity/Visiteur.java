package com.miage.app.Entity;

public class Visiteur extends User{
    public Visiteur(String nom, String prenom, String city, String mdp, String email) {
        super(nom, prenom, city, mdp, email);
    }

    @Override
    public void displayUser() {

    }
}
