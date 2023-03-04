package project;

import java.util.ArrayList;
import java.util.List;

public class Artiste {

    static List<Oeuvre> realisation = new ArrayList<Oeuvre>();
    
    public String nom;
    public String prenom;
    public String dateNaissance;

    public Artiste(String nom, String prenom, String pseudo, String dateNaissance, List<Oeuvre> realisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getArtiste() {
        return this.nom + " " + this.prenom;
    }

}
