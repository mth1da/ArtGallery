package com.miage.app.dao;

import com.miage.app.Entity.Oeuvre;
import com.miage.app.Entity.TypeOeuvre;

public interface TypeOeuvreDAO {
    public abstract void createType(String name, String description);

    public abstract void updateType(TypeOeuvre type);

    public abstract void deleteType(TypeOeuvre type);

    public abstract Iterable<TypeOeuvre> getAllTypes();
}
