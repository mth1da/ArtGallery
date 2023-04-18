package com.miage.app.dao.repository;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.ArtisteDAO;
import java.util.ArrayList;
import java.util.List;

public class ArtisteRepository implements ArtisteDAO {

    public void createArtiste(String name, String lastName) {

    }


    @Override
    public Artiste getIdByNameAndLastName(String name, String lastName) {
        return null;
    }

    @Override
    public Iterable<Artiste> getAllArtists() {
        return null;
    }

}
