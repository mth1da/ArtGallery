package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public class InscriptionProprietaire implements Inscription{


    @Override
    public User creeCompte() {
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

    }

}
