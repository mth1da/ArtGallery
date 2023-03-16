package com.miage.app.Entity;

import java.util.ArrayList;
import java.util.List;

public class Proprietaire extends Visiteur{
    private List<Oeuvre> mesOeuvres=new ArrayList<Oeuvre>();
    private String condi;

    public Proprietaire(String nom, String prenom,String mdp,String email,String conditions) {
        super(nom, prenom, mdp,email);
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

    @Override
    public String getType() {
        return "proprietaire";
    }
}
