package com.miage.app;

import com.miage.app.fonctionnalitees.Connexion;
import com.miage.app.fonctionnalitees.Inscription;
import com.miage.app.utilisateurs.User;

import java.util.Scanner;

public class App 
{
    static Scanner sc = new Scanner(System.in);
    
    public static void main( String[] args )
    {

        User utilisateur1 = new User("Naloufi", "Amel", "AmelNal22", "photoPath", "motDePasse");
        User utilisateur2 = new User("Gulam", "Meryam", "MerGul22", "photoPath", "motDePasse1");
        User.ajoutUtilisateur(utilisateur1);
        User.ajoutUtilisateur(utilisateur2);
        System.out.println("Avez-vous un compte ? [yes/no]");
        String x = sc.nextLine();
        if(x.equals("yes") || x.equals("Yes") || x.equals("YES")) {
            Connexion.connexion();
        } else if(x.equals("no") || x.equals("No") || x.equals("NO")){
            Inscription.inscription();
        }
    }
}
