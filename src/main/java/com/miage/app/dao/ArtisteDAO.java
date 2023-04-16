package com.miage.app.dao;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.TypeOeuvre;

import java.sql.SQLException;


public interface ArtisteDAO {
    void createArtiste(String name, String lastName);

    Artiste getIdByNameAndLastName(String name, String lastName);

    Iterable<Artiste> getAllArtists();
}
