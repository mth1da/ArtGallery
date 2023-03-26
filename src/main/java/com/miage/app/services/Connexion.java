package com.miage.app.services;

import com.miage.app.dao.UserDAO;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion {

    private UserDAO userDAO;

    public Connexion(UserDAO userDAO){
        this.userDAO=userDAO;
    }

    public  String connexionValide(String email,String mdp){
        if(!verifCompteExiste(email)){
            return "Votre compte n'existe pas, veuillez vous inscrire";
        }
        if(!mdpValide(email,mdp)){
            return "Mot de passe invalide";
        }
        return "";
    }


    public boolean mdpValide(String email,String mdp){
        return userDAO.getUserConnection(email,mdp);
    }
    public boolean verifCompteExiste(String email){
        return this.userDAO.getUserByMail(email)!=null;
    }

}
