package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;


public interface Inscription {

    public String creeCompte();

    //Retourne true si l'email existe
    public abstract boolean verifCompteExiste(String email);

    public abstract boolean mdpValide(String mdp);

    public abstract void saveAccount(User user);

    public abstract String verificationCoordonneeCompte(String email,String password);



}
