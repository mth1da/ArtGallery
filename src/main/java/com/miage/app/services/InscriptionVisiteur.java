package com.miage.app.services;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.UserDAO;

public class InscriptionVisiteur implements Inscription {
    private String[] infoCompte;
    private UserDAO userDAO;

    //Constructeur
    public InscriptionVisiteur(String[] str,UserDAO userDAO){
        this.infoCompte=str;
        this.userDAO=userDAO;
    }

    @Override
    public String creeCompte() {
        //Méthode pour la création du compte
        //Appelle les méthodes afin de vérifier si le compte existe ou si le mot de passe n'est pas valide etc...
        String reponse=Inscription.verificationCoordonneeCompte(infoCompte[3],infoCompte[2],this.userDAO);
        if(reponse.equals("")){
            //Si le compte n'existe pas et les données ont bien été saisis:
            User user=new Visiteur(infoCompte[0],infoCompte[1],infoCompte[2],infoCompte[3]);
            //Création de nouveau visiteur
            saveAccount(user);
            reponse="Votre compte a bien été enregisté";
        }
        return reponse;
    }

    @Override
    public void saveAccount(User user) {
        //Sauvegarde du compte avec la création du User dans la base de données
        userDAO.createUser(user);
    }


}
