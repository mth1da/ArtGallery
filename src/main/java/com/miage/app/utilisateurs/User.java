package com.miage.app.utilisateurs;

import java.util.List;

import com.miage.app.repository.UserRepository;

public class User implements UserRepository {

    public int id;
    public String email;
    public String motDePasse;
    public String nom;
    public String prenom;
    public String photoPath;
    public String pseudo;

    public User(String nom, String prenom, String pseudo, String photoPath, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.photoPath = photoPath;
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    //Ajouter un utilisateur (système d’inscription)

    public static List<User> ajoutUtilisateur(User utilisateur) {

        utilisateurs.add(utilisateur);
        return utilisateurs;

    }

    //Authentification d’un utilisateur avec un système propre à votre application ou via 
    //des systèmes existants (Google, Facebook, Apple..)

    public static boolean authentification(String motDePasse, String pseudo) {

    for(User utilisateur : utilisateurs) {
        if(utilisateur.getMotDePasse().equals(motDePasse) && utilisateur.getPseudo().equals(pseudo)) {
            afficheUtilisateur(utilisateur);
            return true;
        }
    }
    return false;
    }

    public static void afficheUtilisateur(User utilisateur) {
        System.out.print(utilisateur.getPrenom() + " " + utilisateur.getNom() + ", ");
    }

    //Modifier son profil

    public void modifierProfil(String newMotDePasse, String newPhotoPath, String newNom, String newPrenom) {
        this.motDePasse = newMotDePasse;
        this.photoPath = newPhotoPath;
        this.nom = newNom;
        this.prenom = newPrenom; 
    }

    public void modifierMotDePasse(String newMotDePasse) {
        this.motDePasse = newMotDePasse;
    }

    public boolean modification() {
        return false;
    }

}