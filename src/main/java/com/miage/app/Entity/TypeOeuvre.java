package com.miage.app.Entity;

public class TypeOeuvre {

    private int id;
    private String nom_type;
    private String caracteristique;

    public TypeOeuvre(int id, String nom_type, String caracteristique){
        this.id=id;
        this.nom_type=nom_type;
        this.caracteristique=caracteristique;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getType(){
        return this.nom_type;
    }

    public void setType(String nom_type){
        this.nom_type=nom_type;
    }

    public String getCaracteristique(){
        return this.caracteristique;
    }

    public void setCaracteristique(String caracteristique){
        this.caracteristique=caracteristique;
    }
}
