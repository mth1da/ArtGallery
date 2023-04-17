package com.miage.app.services;

import com.miage.app.Entity.User;
import com.miage.app.dao.UserDAO;

public class InscriptionLocal implements Inscription{
    private UserDAO userDAO;
    private User user;

    public InscriptionLocal(UserDAO userDAO, User us){
        this.userDAO=userDAO;
        this.user=us;
    }

    @Override
    public String creeCompte() {
        String reponse=verificationCoordonneeCompte(user.getEmail(),user.getMdp());
        //Si le compte n'existe pas et les données ont bien été saisies:
        if(reponse.equals("")){
            saveAccount(user);
            reponse="Votre compte a bien été enregistré";
        }
        return reponse;
    }

    @Override
    public void saveAccount(User user) {
        //Sauvegarde du compte avec la création du User dans la base de données
        userDAO.createUser(user);
    }

    //Retourne true si l'email existe
    public boolean verifCompteExiste(String email){
        return this.userDAO.getUserByMail(email) != null;
    }

    public boolean mdpValide(String mdp){
        //Format du mot de passe afin qu'il soit valide
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        // return mdp.matches(pattern);
        return true;
    }


    public String verificationCoordonneeCompte(String email,String password){
        //Vérifie lors de l'inscription que le compte n'existe pas et que la forme du mot de passe est correct
        String reponse="";
        //Si le compte n'existe pas et les données ont bien été saisis:
        if(verifCompteExiste(email)){
            reponse="Votre compte existe déjà veuillez vous connecter";
        }else{
            if(!mdpValide(password)){
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
