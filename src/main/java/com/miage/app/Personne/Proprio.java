package com.miage.app.Personne;

import java.util.ArrayList;
import java.util.List;

import com.miage.app.Oeuvre.Oeuvre;

public class Proprio extends Visiteur{

    private List<Oeuvre> mesOeuvres=new ArrayList<Oeuvre>();
    private String condi;

    public Proprio(String nom, String prenom,String pseudo,String mdp,String email,String conditions) {
        super(nom, prenom, pseudo,mdp,email);
        this.condi=conditions;
    }

    @Override
    public void displayUser() {
        // TODO Auto-generated method stub
        System.out.println("Je  suis le propriétaire "+getNom()+" "+getPreNom());
    
    }

    public void addOeuvres(Oeuvre oeuvre){
        this.mesOeuvres.add(oeuvre);
    }

    public void vendreOeuvre(Oeuvre oeuvre){
        this.mesOeuvres.remove(oeuvre);
    }

    public List<Oeuvre> getOeuvres(){
        return this.mesOeuvres;
    }

}
