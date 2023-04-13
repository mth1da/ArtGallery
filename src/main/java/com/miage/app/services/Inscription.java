package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public interface Inscription {

    public String creeCompte();

    //Retourne true si l'email existe
    public static boolean verifCompteExiste(String email,UserDAO userDAO){
        return userDAO.getUserByMail(email) != null;
    }

    public static boolean mdpValide(String mdp){
        //Format du mot de passe afin qu'il soit valide
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        return mdp.matches(pattern);
       //return true;
    }

    public abstract void saveAccount(User user);

    public static String verificationCoordonneeCompte(String email,String password,UserDAO userDAO){
        //Vérifie lors de l'inscription que le compte n'existe pas et que la forme du mot de passe est correct
        String reponse="";
        //Si le compte n'existe pas et les données ont bien été saisis:
        if(Inscription.verifCompteExiste(email, userDAO)){
            reponse="Votre compte existe déjà veuillez vous connecter";
        }else{
            if(!Inscription.mdpValide(password)){
                reponse="Votre mot de passe est invalide veuillez vous assurez que le mdp contient:" +
                        "au moins un chiffre" +
                        "au moins une lettre minusucule" +
                        "au moins une lettre majuscule" +
                        "au moins un caractère spécial" +
                        "pas d'espace" +
                        "au moins 8 caractères au total";
            }
        }
        return reponse;
    }



}
