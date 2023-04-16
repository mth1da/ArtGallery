package com.miage.app.services;

import com.miage.app.Entity.User;

public class InscriptionGoogle implements Inscription{
    @Override
    public String creeCompte() {
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

    @Override
    public String verificationCoordonneeCompte(String email, String password) {
        return null;
    }
}
