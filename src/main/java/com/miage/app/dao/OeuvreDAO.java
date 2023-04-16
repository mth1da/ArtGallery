package com.miage.app.dao;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Oeuvre;


public interface OeuvreDAO {

    void createOeuvre(String title, int userID, Artiste art, Double price);

    public abstract void createOeuvre(Oeuvre o);

    public abstract void updateOeuvre(Oeuvre o);

    public abstract void deleteOeuvre(Oeuvre o);

    void updateOeuvre(String title, Double price, int id);

    void deleteOeuvre(int idOeuvre);

    public abstract Oeuvre getOeuvreById(int o);

    public abstract Iterable<Oeuvre> getAllOeuvres();

    public abstract Iterable<Oeuvre> getAllUserOeuvres(int id);

}
