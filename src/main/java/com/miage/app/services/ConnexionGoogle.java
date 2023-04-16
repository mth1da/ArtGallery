package com.miage.app.services;

public class ConnexionGoogle implements Connexion{
    @Override
    public String connexionValide(String email, String mdp) {
        return null;
    }

    @Override
    public boolean mdpValide(String email, String mdp) {
        return false;
    }

    @Override
    public boolean verifCompteExiste(String email) {
        return false;
    }
}
