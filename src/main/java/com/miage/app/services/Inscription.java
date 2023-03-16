package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public interface Inscription {

    public User creeCompte();

    public static boolean verifCompteExiste(String email){
        return true;
    }

    public static boolean mdpValide(String mdp){
        return  true;
    }

    public abstract void saveAccount(User user);



}
