package com.miage.app.Entity;

public abstract class  User {
private String nom;
private String prenom;
private String pseudo;
private String mdp;
private final String EMAIL;
private boolean estConnecter;

protected User(String nom,String prenom,String pseudo,String mdp,String email){
        this.nom=nom;
        this.prenom=prenom;
        this.pseudo=pseudo;
        this.mdp=mdp;
        this.EMAIL=email;
        }

public void setConnexion(boolean resp){
        this.estConnecter=resp;
        }

public String getNom(){
        return this.nom;
        }

public String getPreNom(){
        return this.prenom;
        }

public String getPseudo(){
        return this.pseudo;
        }

public String getMdp(){
        return this.mdp;
        }

public String getEmail(){
        return this.EMAIL;
        }

public boolean getInfoConnexion(){
        return this.estConnecter;
        }

public abstract void displayUser();

public void setNom(String nom){
        this.nom=nom;
}

public void setPrenom(String prenom){
        this.prenom=prenom;
}

public void setMdp(String mdp){
        this.mdp=mdp;
}


}