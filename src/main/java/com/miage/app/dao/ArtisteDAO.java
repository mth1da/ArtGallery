package com.miage.app.dao;

import com.miage.app.Entity.Artiste;

public interface ArtisteDAO {
    void createArtiste(String name, String lastName);

    Artiste getIdByNameAndLastName(String name, String lastName);

    Iterable<Artiste> getAllArtists();
}
