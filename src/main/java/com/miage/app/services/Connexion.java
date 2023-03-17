package com.miage.app.services;

public interface Connexion {

    public boolean emailValide(String email);
    public static boolean mdpValide(String mdp){
        return  true;
    }
    public static boolean verifCompteExiste(String email){
        return true;
    }

}
