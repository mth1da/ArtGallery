package com.miage.app.services;

import com.miage.app.Entity.User;

public class InscriptionVisiteur implements Inscription {
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

    @Override
    public void deleteAccount(User user) {

    }
}
