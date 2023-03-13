package com.miage.app.dao;

import com.miage.app.Entity.Oeuvre;

import java.util.List;

public interface OeuvreDAO {

    public abstract void createOeuvre(Oeuvre o);

    public abstract void updateOeuvre(Oeuvre o);

    public abstract void deleteOeuvre(Oeuvre o);

    public abstract Oeuvre getOeuvreById(Oeuvre o);

    public abstract Iterable<Oeuvre> getAllOeuvres();
}
