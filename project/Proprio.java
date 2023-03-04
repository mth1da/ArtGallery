package project;

import java.util.ArrayList;
import java.util.List;

public class Proprio extends User{

    static List<Oeuvre> oeuvres = new ArrayList<Oeuvre>(); 
    
    public Proprio(String nom, String prenom, String pseudo, String photoPath, String motDePasse) {
        super(nom, prenom, pseudo, photoPath, motDePasse);
    }

    //Afficher la liste des oeuvres exposées 

    public void afficheOeuvre() {
        for(Oeuvre oeuvre: oeuvres) {
            System.out.println(oeuvre);
        }
    }
    
}
