package com.miage.app.fonctionnalitees;

import java.util.Scanner;

import com.miage.app.repository.UserRepository;
import com.miage.app.utilisateurs.Proprio;

public class Inscription {
    
    static Scanner sc = new Scanner(System.in);

    public static void inscription() {
        System.out.println("Saisissez votre nom:");
        String nom = sc.nextLine();
        System.out.println("Saisissez votre prenom:");
        String prenom = sc.nextLine();
        System.out.println("Saisissez votre pseudo:");
        String pseudo = sc.nextLine();
        UserRepository.pseudo.add(pseudo);
        System.out.println("Saisissez votre mot de passe:");
        String mdp = sc.nextLine();
        UserRepository.motDePasse.add(mdp);
        System.out.println("Etes-vous un propriétaire voulant publier une oeuvre ? [yes/no]");
        String response = sc.nextLine();
        if(response.equals("yes")) {
            Proprio newProprio = new Proprio(nom, prenom, pseudo, null, mdp, null);
            UserRepository.proprietaire.add(newProprio);
            UserRepository.utilisateurs.add(newProprio);
            System.out.println("Votre compte a été créé !");
            System.out.println("Voulez-vous publier une oeuvre ? [yes/no]");
        }
    }
}
