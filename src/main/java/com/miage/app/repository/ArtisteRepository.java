package com.miage.app.repository;

import java.util.ArrayList;
import java.util.List;

import com.miage.app.oeuvres.Oeuvre;
import com.miage.app.utilisateurs.Artiste;

public interface ArtisteRepository {
    
    static List<Oeuvre> realisation = new ArrayList<Oeuvre>();

    static List<Artiste> artistes = new ArrayList<Artiste>();
    
}
