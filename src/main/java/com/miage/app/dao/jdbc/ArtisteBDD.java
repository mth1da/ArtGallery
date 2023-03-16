package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.ArtisteDAO;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ArtisteBDD implements ArtisteDAO {
    @Override
    public void createArtiste(Artiste artiste){
    }

    @Override
    public void updateArtiste(Artiste artiste) {

    }

    @Override
    public void deleteArtiste(Artiste artiste) {

    }

    @Override
    public Artiste getArtisteById(int id) {
        return null;
    }

    @Override
    public Iterable<Artiste> getAllArtistes() {
        return null;
    }


}
