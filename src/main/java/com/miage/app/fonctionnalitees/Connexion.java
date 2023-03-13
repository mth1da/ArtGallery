package com.miage.app.fonctionnalitees;

import com.miage.app.utilisateurs.*;
import java.util.Scanner;

public class Connexion {
    
    static Scanner sc = new Scanner(System.in);

    public static void connexion() {
        System.out.println("Saisissez votre pseudo:");
        String pseudo = sc.nextLine();
        System.out.println("Saisissez votre mot de passe:");
        String mdp = sc.nextLine();
        if(User.authentification(mdp, pseudo) == true) {
            System.out.println("nous vous souhaitons la bienvenue sur votre compte !" );
            System.out.println("Voulez-vous modifier un élement de votre profil ? [yes/no]");
            String b = sc.nextLine();
            if(b.equals("yes")){
                System.out.println("Quel élément voulez-vous modifier ?");
                System.out.println("Le mot de passe ? [yes/no]");
                String a = sc.nextLine();
                if(a.equals("yes")){
                    System.out.println("Saisissez votre nouveau mot de passe:");
                    String u = sc.nextLine();
                    mdp = u;
                    System.out.println("Votre nouveau mot de passe est: " + mdp);
                }
                if(a.equals("no")) {
                    System.out.println("Le pseudo ? [yes/no]");
                    String k = sc.nextLine();
                    if(k.equals("yes")) {
                        System.out.println("Saisissez votre nouveau pseudo:");
                        String z = sc.nextLine();
                        pseudo = z;
                        System.out.println("Votre nouveau pseudo est: " + pseudo);
                    }
                }
            }
        } else {
            System.out.println("Authentification échouée, voulez-vous rééssayer ? [yes/no]");
            String y = sc.nextLine();
            if(y.equals("yes")){
                connexion();
            }
        }
    }
}

