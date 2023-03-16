package com.miage.app.services;

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
    public User creeCompte() {
        //appel les methodes pour verifier compte existe deja ou non mdp valide ...
       // tring nom, String prenom, String city, String mdp, String email
        User user=new Visiteur(infoCompte[0],infoCompte[1],infoCompte[2],infoCompte[3]);
        saveAccount(user);
        return null;
    }

    @Override
    public boolean verifCompteExiste(String email) {
        return false;
    }

    @Override
    public boolean mdpValide(String mdp) {
        return false;
    }

    @Override
    public void saveAccount(User user) {
        userDAO.createUser(user);
    }


}
