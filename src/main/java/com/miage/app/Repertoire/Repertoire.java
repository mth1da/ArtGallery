package com.miage.app.Repertoire;

import java.util.*;

import com.miage.app.Fonctionnalitees.Critique;
import com.miage.app.Oeuvre.Oeuvre;
import com.miage.app.Personne.User;

public class Repertoire {
    private static List<Oeuvre> ouvres=new ArrayList<Oeuvre>();
    private static List<User> usersInscrit=new ArrayList<User>();
    private static List<Critique> critiques=new ArrayList<Critique>();
    private static List<User> userConnecter=new ArrayList<User>();

    private Repertoire(){}

    public List<Oeuvre> getOeuvres(){
        return ouvres;
    }

    public List<User> getUserInscrit(){
        return usersInscrit;
    }

    public List<Critique> getCritiques(){
        return critiques;
    }

    public List<User> getUserConnecter(){
        return userConnecter;
    }

    public static void addOeuvres(Oeuvre oeuvres){
        ouvres.add(oeuvres);
    }

    public static void addUserInscrit(User newUser){
        usersInscrit.add(newUser);
    }

    public static void dellUserInscrit(User newUser){
        usersInscrit.remove(newUser);
    }

    public static void addCritiques(Critique critique){
        critiques.add(critique);
    }

    public static void dellCritiques(Critique critique){
        critiques.remove(critique);
    }

    public static void addUserConnecter(User newUser){
        userConnecter.add(newUser);
    }

    public static void dellUserConnecter(User newUser){
        userConnecter.remove(newUser);
    }



    public static void displayOuvres(){
        System.out.println("Les oeuvres sont :");
        for (Oeuvre o : ouvres){
            System.out.println(o);
        }

    }

    public static User findUser(String pseudo,String mdp){
        for(User u: usersInscrit){
            if(u.getPseudo().equals(pseudo) && (u.getMdp().equals(mdp))){
                return u;
            }
        }
        return null;
    }

    public static User findUserByEmail(String email){
        for(User u: usersInscrit){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    public static User findUserByPseudo(String pseudo){
        for(User u: usersInscrit){
            if(u.getPseudo().equals(pseudo)){
                return u;
            }
        }
        return null;
    }

    public static void displayUsersInscrit(){
        System.out.println("Les users inscrits sont :");
        for(User u : usersInscrit){
            System.out.println(u.getNom()+" "+u.getPreNom()+" "+u.getPseudo());
        }
    }

    public static void displayUsersConnceter(){
        System.out.println("Les users connectées sont :");
        for(User u : userConnecter){
            System.out.println(u.getNom()+" "+u.getPreNom()+" "+u.getPseudo());
        }
    }

    public static void displayCritiques(){
        System.out.println("Les critiques sont : \n");
        for(Critique u : critiques){
            System.out.println("pseudo  : "+u.getUser().getPseudo()+"            : "+u.getCommentaire()+" \n note             "+u.getNote()+" \n");
        }
    }
   
}
