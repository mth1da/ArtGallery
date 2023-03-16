package com.miage.app.Entity;

public class Visiteur extends User{

    public Visiteur(String nom, String prenom, String city, String mdp, String email) {
        super(nom, prenom, city, mdp, email);
    }

    @Override
    public void displayUser() {
        System.out.println("Coordonnées du Visiteur : ");
        System.out.println("Nom : "+getNom());
        System.out.println("Prénom : "+getPreNom());
        System.out.println("City : "+getCity());
        System.out.println("Email : "+getEmail());
    }
}
