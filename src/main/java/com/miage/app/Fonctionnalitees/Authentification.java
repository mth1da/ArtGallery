package com.miage.app.Fonctionnalitees;

import java.util.Scanner;

import com.miage.app.Personne.User;
import com.miage.app.Repertoire.Repertoire;

public class Authentification {
    static Scanner sc=new Scanner(System.in);
    private final String DATE;
    private final String APPAREIL;
    private final String pseudo;
    private final String mdp;
    private boolean statutAuthrntification;
    private User user;

    public void getInfoAuthentification(){
        System.out.println("L'utilisateurs "+pseudo+" a tenter de se connecter avec l'appareil "+APPAREIL+" le "+DATE+"statut de l'authentification "+statutAuthrntification);
    }
    
    public Authentification(String date,String appareil){
        System.out.println("Entrez le pseudo");
        this.pseudo=sc.nextLine();
        System.out.println("entre le mdp");
        this.mdp=sc.nextLine();
        this.APPAREIL=appareil;
        this.DATE=date;
    }

    public User getUser(){
        return this.user;
    }

    public boolean getStatutConnexion(){
        return this.statutAuthrntification;
    }

    public void seConnecter(){
        if (verifCompteExiste(this.pseudo,this.mdp)){
            User u1=Repertoire.findUser(pseudo, mdp);
            u1.setConnexion(true);
            this.user=u1;
            Repertoire.addUserConnecter(u1);
            statutAuthrntification=true;
        }else{
            System.out.println("echec d'authentification");
            statutAuthrntification=false;
        }
    }

    public boolean verifCompteExiste(String pseudo,String mdp){
        return (Repertoire.findUser(pseudo, mdp)!=null);
    }

    public void seDeconnecter(User user){
        user.setConnexion(false);
        Repertoire.dellUserConnecter(user);
    }   
}
