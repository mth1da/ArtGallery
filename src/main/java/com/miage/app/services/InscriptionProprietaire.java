package com.miage.app.services;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public class InscriptionProprietaire implements Inscription{
    private String[] infoCompte;
    private UserDAO userDAO;

    public InscriptionProprietaire(String[] str,UserDAO userDAO){
        this.infoCompte=str;
        this.userDAO=userDAO;
    }

    @Override
    public String creeCompte() {
        //appel les methodes pour verifier compte existe deja ou non mdp valide ...
        // tring nom, String prenom, String city, String mdp, String email
        String reponse=Inscription.verificationCoordonneeCompte(infoCompte[3],infoCompte[2],this.userDAO);
        //Si le compte n'existe pas et les données ont bien été saisis:
        if(reponse.equals("")){
            //Création de nouveau propriétaire
            User user=new Proprietaire(infoCompte[0],infoCompte[1],infoCompte[2],infoCompte[3]);
            saveAccount(user);
            reponse="Votre compte a bien était enregister";
        }
        return reponse;
    }

    @Override
    public void saveAccount(User user) {
        //Sauvegarde du compte avec la création du User dans la base de données
        userDAO.createUser(user);
    }

}
