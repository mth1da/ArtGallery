package com.miage.app.services;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.UserDAO;

public class InscriptionVisiteur implements Inscription {
    private String[] infoCompte;
    private UserDAO userDAO;

    public InscriptionVisiteur(String[] str,UserDAO userDAO){
        this.infoCompte=str;
        this.userDAO=userDAO;
    }

    @Override
    public String creeCompte() {
        //appel les methodes pour verifier compte existe deja ou non mdp valide ...
       // tring nom, String prenom, String city, String mdp, String email
        String reponse=Inscription.verificationCoordonneeCompte(infoCompte[3],infoCompte[2],this.userDAO);
        if(reponse.equals("")){
            User user=new Visiteur(infoCompte[0],infoCompte[1],infoCompte[2],infoCompte[3]);
            saveAccount(user);
            reponse="Votre compte a bien était enregister";
        }
        return reponse;
    }

    @Override
    public void saveAccount(User user) {
        userDAO.createUser(user);
    }


}