package com.miage.app.repository;

import java.util.ArrayList;
import java.util.List;

import com.miage.app.utilisateurs.Proprio;
import com.miage.app.utilisateurs.User;
import com.miage.app.utilisateurs.Visiteur;

public interface UserRepository {
    
    public static List<User> utilisateurs = new ArrayList<User>(); 

    public static List<Visiteur> visiteurs = new ArrayList<Visiteur>(); 

    public static List<Proprio> proprietaire = new ArrayList<Proprio>(); 

    public static List<String> motDePasse = new ArrayList<String>();

    public static List<String> pseudo = new ArrayList<String>();


}
