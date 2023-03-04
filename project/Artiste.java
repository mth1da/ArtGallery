package project;

import java.util.ArrayList;
import java.util.List;

public class Artiste {

    static List<Oeuvre> realisation = new ArrayList<Oeuvre>();
    
    public static String nom;
    public static String prenom;
    public static String dateNaissance;

    public Artiste(String nom, String prenom, String pseudo, String dateNaissance, List<Oeuvre> realisation) {

    }

    public static String getArtiste() {
        return nom + " " + prenom;
    }

}
