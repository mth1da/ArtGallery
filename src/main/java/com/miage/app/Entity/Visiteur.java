package com.miage.app.Entity;

public class Visiteur extends User{

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
}