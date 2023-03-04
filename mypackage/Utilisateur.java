package mypackage;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

    public String nom;
    public String prenom;
    public String pseudo;
    public String photoPath;
    public String motDePasse;

    List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>(); 

    static List<Oeuvre> oeuvres = new ArrayList<Oeuvre>(); 

    public Utilisateur(String nom, String prenom, String pseudo, String photoPath, String motDePasse) {
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
}
