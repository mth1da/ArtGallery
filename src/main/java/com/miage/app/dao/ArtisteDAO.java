package com.miage.app.dao;

import com.miage.app.Entity.Artiste;
import java.sql.SQLException;


public interface ArtisteDAO {
    void createArtiste(String name, String lastName);


    Artiste getIdByNameAndLastName(String name, String lastName);
}
