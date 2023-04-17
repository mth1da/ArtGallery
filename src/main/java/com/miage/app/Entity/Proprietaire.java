package com.miage.app.Entity;

import java.util.ArrayList;
import java.util.List;

public class Proprietaire extends User{
    private List<Oeuvre> mesOeuvres=new ArrayList<Oeuvre>();

    public Proprietaire(String nom, String prenom,String mdp,String email) {
        super(nom, prenom, mdp,email);

    }

    @Override
    public void displayUser() {
        // TODO Auto-generated method stub
        System.out.println("Je suis le propriétaire "+getNom()+" "+getPreNom());

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
