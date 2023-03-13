package com.miage.app.Entity;

public class Visiteur extends User{
    protected Visiteur(String nom, String prenom, String pseudo, String mdp, String email) {
        super(nom, prenom, pseudo, mdp, email);
    }

    @Override
    public void displayUser() {

    }
}
