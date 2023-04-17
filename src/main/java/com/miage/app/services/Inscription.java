package com.miage.app.services;

import com.miage.app.Entity.User;


public interface Inscription {

    String creeCompte();

    //Retourne true si l'email existe
    boolean verifCompteExiste(String email);

    boolean mdpValide(String mdp);

    void saveAccount(User user);

    String verificationCoordonneeCompte(String email,String password);

}
