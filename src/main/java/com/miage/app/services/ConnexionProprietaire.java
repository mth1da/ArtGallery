package com.miage.app.services;

public class ConnexionProprietaire implements Connexion{

    @Override
    public boolean emailValide(String email) {
        return false;
    }

}