package com.miage.app.dao;

import com.miage.app.Entity.Artiste;

import java.sql.SQLException;
import java.util.List;

public interface ArtisteDAO {
    public abstract void createArtiste(Artiste artiste) throws SQLException;

    public abstract void updateArtiste(Artiste artiste);

    public abstract void deleteArtiste(Artiste artiste);

    public abstract Artiste getArtisteById(int id);

    public abstract Iterable<Artiste> getAllArtistes();
}
