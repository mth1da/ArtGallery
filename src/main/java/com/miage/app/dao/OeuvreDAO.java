package com.miage.app.dao;

import com.miage.app.Entity.Oeuvre;


public interface OeuvreDAO {

    public abstract void createOeuvre(Oeuvre o);

    public abstract void updateOeuvre(Oeuvre o);

    public abstract void deleteOeuvre(Oeuvre o);

    public abstract Oeuvre getOeuvreById(int o);

    public abstract Iterable<Oeuvre> getAllOeuvres();

    public abstract Iterable<Oeuvre> getAllUserOeuvres(int id);

}
