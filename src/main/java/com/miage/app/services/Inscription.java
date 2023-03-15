package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public interface Inscription {

    public User creeCompte();

    public boolean verifCompteExiste(String email);

    public boolean mdpValide(String mdp);

    public void saveAccount(User user);



}
