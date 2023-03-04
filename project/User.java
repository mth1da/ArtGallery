package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    public int id;
    public String email;
    public String motDePasse;
    public String nom;
    public String prenom;
    public String photoPath;
    public String pseudo;

    static List<User> utilisateurs = new ArrayList<User>(); 

    public User(String nom, String prenom, String pseudo, String photoPath, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.photoPath = photoPath;
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    //Ajouter un utilisateur (système d’inscription)

    public static List<User> ajoutUtilisateur(User utilisateur) {

        utilisateurs.add(utilisateur);
        return utilisateurs;

    }

    //Authentification d’un utilisateur avec un système propre à votre application ou via 
    //des systèmes existants (Google, Facebook, Apple..)

    public static boolean authentification(String motDePasse, String pseudo) {

    for(User utilisateur : utilisateurs) {
        if(utilisateur.getMotDePasse().equals(motDePasse) && utilisateur.getPseudo().equals(pseudo)) {
            afficheUtilisateur(utilisateur);
            return true;
        }
    }
    return false;
    }

    public static void afficheUtilisateur(User utilisateur) {
        System.out.print(utilisateur.getPrenom() + " " + utilisateur.getNom() + ", ");
    }

    //Modifier son profil

    public void modifierProfil(String newMotDePasse, String newPhotoPath, String newNom, String newPrenom) {
        this.motDePasse = newMotDePasse;
        this.photoPath = newPhotoPath;
        this.nom = newNom;
        this.prenom = newPrenom; 
    }

    public void modifierMotDePasse(String newMotDePasse) {
        this.motDePasse = newMotDePasse;
    }

    public boolean modification() {
        return false;
    }

    static Scanner sc = new Scanner(System.in);

    public static void connexion() {
        System.out.println("Avez-vous un compte ? [yes/no]");
        String x = sc.nextLine();
        if(x.equals("yes")) {
            System.out.println("Saisissez votre pseudo:");
            String pseudo = sc.nextLine();
            System.out.println("Saisissez votre mot de passe:");
            String mdp = sc.nextLine();
            if(authentification(mdp, pseudo) == true) {
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
        if(x.equals("no")) {
            System.out.println("Voulez-vous vous inscrire ? [yes/no]");
            
        }
    }

    
    public static void main(String args[]) {
        User utilisateur1 = new User("Naloufi", "Amel", "AmelNal22", "photoPath", "motDePasse");
        User utilisateur2 = new User("Gulam", "Meryam", "MerGul22", "photoPath", "motDePasse1");
        ajoutUtilisateur(utilisateur1);
        ajoutUtilisateur(utilisateur2);
        connexion();
    }

}

