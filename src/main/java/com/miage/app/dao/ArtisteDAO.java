package com.miage.app.dao;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Oeuvre;

import java.sql.SQLException;


public interface ArtisteDAO {
    public abstract void createArtiste(String name, String lastName);

    public abstract void updateArtiste(Artiste artiste);

    public abstract void deleteArtiste(Artiste artiste);

    public abstract Artiste getArtisteById(int id);

    public abstract Iterable<Artiste> getAllArtistes();

    public Artiste getIdByNameAndLastName(String name, String lastName);
}
