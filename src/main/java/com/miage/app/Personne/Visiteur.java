package com.miage.app.Personne;

import com.miage.app.Oeuvre.Oeuvre;

public class Visiteur extends User{
    protected Visiteur(String nom, String prenom,String pseudo,String mdp,String email) {
        super(nom, prenom,pseudo,mdp,email);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void displayUser() {
        // TODO Auto-generated method stub
        System.out.println("Je  suis le visiteur "+getNom()+" "+getPreNom());
    }
    
    public void acheterOeuvre(Oeuvre oeuvre){
        
    }


}
