package com.miage.app.dao;

import com.miage.app.Entity.Artiste;
import java.sql.SQLException;


public interface ArtisteDAO {
    public abstract void createArtiste(Artiste artiste) throws SQLException;

    void createArtiste(String name, String lastName);

    public abstract void updateArtiste(Artiste artiste);

    public abstract void deleteArtiste(Artiste artiste);

    public abstract Artiste getArtisteById(int id);

    public abstract Iterable<Artiste> getAllArtistes();

    Artiste getIdByNameAndLastName(String name, String lastName);
}
