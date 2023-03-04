package project;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

    public int id;
    public String email;
    public String motDePasse;
    public String nom;
    public String prenom;
    public String photoPath;
    public String pseudo;

    List<User> utilisateurs = new ArrayList<User>(); 

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

    public List<User> ajoutUtilisateur(User utilisateur) {

    utilisateurs.add(utilisateur);
    return utilisateurs;
    }

    //Authentification d’un utilisateur avec un système propre à votre application ou via 
    //des systèmes existants (Google, Facebook, Apple..)

    public boolean authentification(String motDePasse, String pseudo) {

    for(User utilisateur : utilisateurs) {
        if(utilisateur.getMotDePasse() == motDePasse && utilisateur.getPseudo() == pseudo) {
            return true;
        }
    }
    return false;
    }

    //Modifier son profil

    public void modifierProfil(String newMotDePasse, String newPhotoPath, String newNom, String newPrenom) {
        this.motDePasse = newMotDePasse;
        this.photoPath = newPhotoPath;
        this.nom = newNom;
        this.prenom = newPrenom; 
    }

    public boolean modification() {
        return false;
    }

}

