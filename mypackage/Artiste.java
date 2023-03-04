package mypackage;

import java.util.List;

public class Artiste extends Utilisateur{

    public Artiste(String nom, String prenom, String pseudo, String photoPath, String motDePasse) {

        super(nom, prenom, pseudo, photoPath, motDePasse);

    }


//Ajouter un utilisateur (système d’inscription)

public List<Utilisateur> ajoutUtilisateur(Utilisateur utilisateur) {

    utilisateurs.add(utilisateur);
    return utilisateurs;
        
}

//Authentification d’un utilisateur avec un système propre à votre application ou via 
//des systèmes existants (Google, Facebook, Apple..)

public boolean authentification(String motDePasse, String pseudo) {

    for(Utilisateur utilisateur : utilisateurs) {
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

//Afficher la liste des oeuvres réalisées 

public void afficheOeuvre() {
    for(Oeuvre oeuvre: oeuvres) {
        System.out.println(oeuvre);
    }
}

}