package com.miage.app.Fonctionnalitees;


import java.util.Scanner;

import com.miage.app.Personne.Proprio;
import com.miage.app.Personne.User;
import com.miage.app.Repertoire.Repertoire;

public class InscriptionProprio implements InsciptionService {
    static Scanner sc=new Scanner(System.in);
    private String date;
    private String appareil;
    private boolean statutInscription;
    private User user;


    public User getUser(){
        return this.user;
    }

    public boolean getStatutInscription(){
        return this.statutInscription;
    }

    public InscriptionProprio(String date,String appareil){
        this.date=date;
        this.appareil=appareil;
    }

    public User creeCompte(){
        System.out.println("taper votre nom");
        String name=sc.nextLine();
        System.out.println("taper votre prenom");
        String prenom=sc.nextLine();
        System.out.println("taper votre pseudo");
        String pseudo=sc.nextLine();
        System.out.println("taper votre mdp");
        String mdp=sc.nextLine();
        System.out.println("taper votre email");
        String email=sc.nextLine();
        if(!verifCompteExiste(email) && !verifPseudoExiste(pseudo) && mdpValide(mdp)){
            User newUser=new Proprio(name,prenom,pseudo,mdp,email,"df");
            saveAccount(newUser);
            return user;
        }
        System.out.println("echec d'inscription");
        this.statutInscription=false;
        return null;
    }


    
    public boolean verifCompteExiste(String email){
        return (Repertoire.findUserByEmail(email)!=null);
    }

    public boolean verifPseudoExiste(String pseudo){
        return (Repertoire.findUserByPseudo(pseudo)!=null);
    }

    public boolean mdpValide(String mdp){
        return true;
    }

    public void saveAccount(User user){
        System.out.println("Votre compte a bien etait enregister");
        Repertoire.addUserInscrit(user);
        this.statutInscription=true;
    }

    public void deleteAccount(User user){
        System.out.println(" Le compte a bien était supprimer ");
        Repertoire.dellUserInscrit(user);
    }

  

    

}
