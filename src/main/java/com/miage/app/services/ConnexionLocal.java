package com.miage.app.services;

import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;

public class ConnexionLocal implements Connexion{

    private UserDAO userDAO;

    public ConnexionLocal(UserDAO userDAO){
        this.userDAO=userDAO;
    }

    @Override
    public  String connexionValide(String email,String mdp){
        if(!verifCompteExiste(email)){
            return "!Erreur ! Votre compte n'existe pas, veuillez vous inscrire";
        }
        if(!mdpValide(email,mdp)){
            return "!Erreur ! Mot de passe invalide";
        }
        int id=this.userDAO.getUserIdByMail(email);
        return  ""+id;
    }

    @Override
    public boolean mdpValide(String email,String mdp){
        return userDAO.getUserConnection(email,mdp);
    }
    @Override
    public boolean verifCompteExiste(String email){
        return this.userDAO.getUserByMail(email)!=null;
    }


}
