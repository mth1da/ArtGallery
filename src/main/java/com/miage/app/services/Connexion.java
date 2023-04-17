package com.miage.app.services;


public interface Connexion {

    String connexionValide(String email,String mdp);

    boolean mdpValide(String email,String mdp);

     boolean verifCompteExiste(String email);

}
