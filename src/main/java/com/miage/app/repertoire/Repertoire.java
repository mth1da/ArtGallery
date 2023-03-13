package com.miage.app.repertoire;

import com.miage.app.utilisateurs.User;

public class Repertoire {
    
    public void afficheUserInscrits() {
        for(User user: User.utilisateurs) {
            System.out.println("Les utilisateurs inscrits: " + user);
        };
    }
}