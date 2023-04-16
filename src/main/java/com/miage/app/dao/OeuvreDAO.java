package com.miage.app.dao;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Oeuvre;


public interface OeuvreDAO {

    void createOeuvre(String title, int userID, Artiste art, Double price);


    void updateOeuvre(String title, Double price, int id);

    void deleteOeuvre(int idOeuvre);

    public abstract Iterable<Oeuvre> getAllUserOeuvres(int id);

}
