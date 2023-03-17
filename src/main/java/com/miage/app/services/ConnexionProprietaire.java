package com.miage.app.services;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.UserDAO;

public class ConnexionProprietaire implements Connexion{

    @Override
    public boolean emailValide(String email) {
        return false;
    }

}
